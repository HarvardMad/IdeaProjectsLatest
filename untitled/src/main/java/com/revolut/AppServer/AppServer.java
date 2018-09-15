package com.revolut.AppServer;

import io.undertow.Undertow;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppServer {
  private static final Logger logger = LoggerFactory.getLogger(AppServer.class);
  public static void AppServerHandler(HttpServerExchange exchange) {
    exchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "text/plain");
    exchange.getResponseSender().send("Hello World!");
  }
  public static void loginHandler(HttpServerExchange exchange) {
    exchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "text/plain");
    exchange.getResponseSender().send("welcome to login!");
  }

  public static void main(String[] args) {
    Undertow server = null;
    final int PORT = 8080;
    final String LOCALHOST = "localhost";
     server = Undertow.builder()
        .addHttpListener(PORT, LOCALHOST,AppServer::AppServerHandler)
         .addHttpListener(PORT, LOCALHOST,AppServer::loginHandler)
        .build();

    logger.info("starting ");
   server.stop();
    server.start();
  }

}
