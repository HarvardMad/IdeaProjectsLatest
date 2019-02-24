package com.revolut.verticles;


import com.google.inject.Guice;
import com.google.inject.Inject;
import com.revolut.accounts.Routes.RouteManager;
import com.revolut.config.GuiceModule;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import java.util.logging.Logger;

/**
 * You can’t do much in Vert.x-land unless you can communicate with a Vertx object!
 * It’s the control centre of Vert.x
 * and it is how you do pretty much everything,
 * including creating clients and servers,
 * getting a reference to the event
 * bus, setting timers, as well as many other things.
 */

public class AppServerVerticle extends AbstractVerticle{

  public static final String LOCALHOST = "localhost";
  public static final int PORT = 8080;
  public static final boolean LOG_ACTIVITY = true;

  Vertx vertx = Vertx.vertx();

  @Inject
  private  RouteManager routeManager;



  @Inject
  Logger logger;



  @Override
  public void start() throws Exception {
    GuiceModule module = new GuiceModule(vertx);
    Guice.createInjector(module).injectMembers(this);
    setUpServerWithLogging(vertx, module);
    vertx.deployVerticle(new CustomerVerticle());
    vertx.deployVerticle(new CouchBaseVerticle());

  }

  private HttpServer setUpServerWithLogging(final Vertx vertx, GuiceModule module) {

    //For debugging purposes, network activity can be logged.
    HttpServerOptions options = new HttpServerOptions()
        .setLogActivity(LOG_ACTIVITY)
        .setHost(LOCALHOST)
        .setPort(PORT);
    logger.info("setting up the server ");
    return vertx.createHttpServer(options)
        .requestHandler(routeManager.establishRoutes(vertx, module)::accept)
        .listen(listenerHandler);



  }

  private Handler<AsyncResult<HttpServer>> listenerHandler = (asyncResult)
      -> {
    if (asyncResult.succeeded()) {
     logger.info("***** Server started to listen *****");
    } else {
     logger.info("server failed");
    }
  };

  @Override
  public Vertx getVertx() {
    return vertx;
  }



}
