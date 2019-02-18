package com.revolut.config;

import com.revolut.exception.ServerFailedToStartException;
import com.revolut.verticles.AppServerVerticle;

public class Runner {

  public static void main(String[] args) {
    AppServerVerticle as = new AppServerVerticle();
    try {
      as.start();

    } catch (Exception e) {
      throw new ServerFailedToStartException(e.getMessage());
    }
  }

}
