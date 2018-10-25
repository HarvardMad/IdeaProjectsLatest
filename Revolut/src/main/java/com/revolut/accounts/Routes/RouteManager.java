package com.revolut.accounts.Routes;

import com.revolut.accounts.handlers.AllRequestHandlers;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class RouteManager {


  public static Router establishRoutes(Vertx vertx){
    Router router = Router.router(vertx);
    // This body handler will be called for all routes
    router.route().handler(BodyHandler.create());
    router.route().path("/hello").handler(AllRequestHandlers.requestHandler);
    router.post("/transfer").handler(AllRequestHandlers.transferHandher);

    return router;
  }
}
