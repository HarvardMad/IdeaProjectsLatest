package com.revolut.accounts.api;

import io.undertow.server.HttpServerExchange;

public class UserRequests {

  public void transferRequest(HttpServerExchange exchange) {

      String requestBody = exchange.getPathParameters().get("transfer").toString();

  }


}
