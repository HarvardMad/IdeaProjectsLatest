package com.revolut.accounts.datamodel;

import com.revolut.accounts.dao.AccountsDAO;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.StatusCodes;


public class UserRoutes {
  //private static final TransferHandler userRequests = new UserRequests();
  private static final AccountsDAO accountsDAO = new AccountsDAO();

  public static void transfer(HttpServerExchange exchange) {


    exchange.setStatusCode(StatusCodes.OK);
    exchange.getResponseSender().send("transfer complete");

  }

}
