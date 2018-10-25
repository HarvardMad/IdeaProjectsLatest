package com.revolut.config;

public class Runner {

  public static void main(String[] args) {
    AppServer as = new AppServer();
    try {
      as.start();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
