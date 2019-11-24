package com.revolut.accounts.Routes;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.revolut.accounts.handlers.AllRequestHandlers;
import com.revolut.config.GuiceModule;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import java.util.logging.Logger;


public  class RouteManager {

  @Inject
  Logger logger;

  @Inject AllRequestHandlers allRequestHandlers;

  Router router;


  public  Router establishRoutes(final Vertx vertx, GuiceModule module){
   Guice.createInjector(module).injectMembers(this);
    router= Router.router(vertx);
    // This body handler will be called for all routes
    router.route().handler(BodyHandler.create());
    router.route().path("/hello").handler(allRequestHandlers.requestHandler);
    router.post("/transfer").handler(allRequestHandlers.transferHandher);
    router.post("/customer").handler(allRequestHandlers.newAccountHandher);
    router.post("/payee").handler(allRequestHandlers.newPayeeHandher);
    router.post("/roundup").handler(allRequestHandlers.roundUpHandler);
    logger.info("router established");
   return router;
  }
}
