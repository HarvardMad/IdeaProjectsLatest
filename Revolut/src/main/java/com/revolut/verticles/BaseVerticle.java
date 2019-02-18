package com.revolut.verticles;

import com.google.inject.Guice;
import com.revolut.config.GuiceModule;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class BaseVerticle extends AbstractVerticle {

  Vertx vertx;

  public BaseVerticle(Vertx vertx){
    this.vertx = vertx;
  }
  @Override
  public void start() throws Exception {
    Guice.createInjector(new GuiceModule(vertx)).injectMembers(this);

  }
}
