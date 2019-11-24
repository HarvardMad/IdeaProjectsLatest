package com.revolut.config;

import com.revolut.verticles.AppServerVerticle;
import io.vertx.core.AbstractVerticle;

public class DockerStarter extends AbstractVerticle {

  @Override
  public void start(){
    AppServerVerticle as = new AppServerVerticle();
    try {
      as.start();

    } catch (Exception e) {
      //throw new ServerFailedToStartException(e.getMessage());
    }
  }

}
