package com.revolut.config;

import com.revolut.accounts.datamodel.TransferHandler;
import io.undertow.Undertow;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.RoutingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppServer {
 private static final Logger logger = LoggerFactory.getLogger(AppServer.class);
  public static void getTransfer(HttpServerExchange httpServerExchange) throws Exception {
     final RoutingHandler ROUTES = new RoutingHandler().post("/transfer",new TransferHandler());
     ROUTES.handleRequest(httpServerExchange);
  }



  public static void main(String[] args) {

    Undertow server = null;
    final int PORT = 8080;
    final String LOCALHOST = "localhost";

     server = Undertow.builder()
        .addHttpListener(PORT, LOCALHOST,AppServer::getTransfer)
        .build();

    server.start();



  }


}
