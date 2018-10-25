package com.revolut.config;


import com.revolut.accounts.Routes.RouteManager;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You can’t do much in Vert.x-land unless you can communicate with a Vertx object!
 * It’s the control centre of Vert.x
 * and it is how you do pretty much everything,
 * including creating clients and servers,
 * getting a reference to the event
 * bus, setting timers, as well as many other things.
 */

public class AppServer extends AbstractVerticle{

  private static final Logger logger = LoggerFactory.getLogger(AppServer.class);

  private HttpServer vertxServer = null;
  Vertx vertx=Vertx.vertx();

  @Override
  public void start() throws Exception {

    HttpServer server = setUpServerWithLogging(vertx);
  }

  private static HttpServer setUpServerWithLogging(Vertx vertx) {

    //For debugging purposes, network activity can be logged.
    HttpServerOptions options = new HttpServerOptions()
        .setLogActivity(true)
        .setHost("localhost")
        .setPort(8080);

    HttpServer server = vertx.createHttpServer(options);
    Router router = RouteManager.establishRoutes(vertx);
    server.requestHandler(router::accept)
        .listen(listenerHandler);

    return server;

  }

  private static Handler<AsyncResult<HttpServer>> listenerHandler = (asyncResult)
      -> {
    if (asyncResult.succeeded()) {
      System.out.println("***** Server started to listen *****");
    } else {
      System.out.println("server failed");
    }
  };



}
