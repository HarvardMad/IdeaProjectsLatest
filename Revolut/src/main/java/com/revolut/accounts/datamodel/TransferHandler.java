package com.revolut.accounts.datamodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revolut.accounts.dao.AccountsDAO;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class TransferHandler implements HttpHandler {

  TransferRequest transferRequest = null;
  private static final AccountsDAO accountsDAO = new AccountsDAO();

  @Override
  public void handleRequest(HttpServerExchange httpServerExchange) {

    accountsDAO.createNewAccount("Adam", 400.00, "12345");
    accountsDAO.createNewAccount("Zac", 250.23, "54321");

    httpServerExchange.getRequestReceiver().receiveFullBytes((exchange, data) -> {
      try {
        ObjectMapper mapper = new ObjectMapper();
        String dataStr = new String(data, "UTF-8");

        TransferRequest request = mapper.readValue(dataStr, TransferRequest.class);
        TransferDetails transferDetails = new TransferDetails(request.getSendersAccountNumber(), request
            .getRecepientsmAccountNumber(), Double.parseDouble(request.getTransferAmount()));

        CurrentAccount fromAcc = accountsDAO.getAccount(transferDetails.sendersAccountNumber);
        CurrentAccount toAcc = accountsDAO.getAccount(transferDetails.recepientsmAccountNumber);
        try {
          CurrentAccount.startMoneyTransferProcess(fromAcc, toAcc, transferDetails.transferAmount);
        } catch (IllegalArgumentException ilg) {
          ilg.printStackTrace();
        }

        MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
        moneyTransferResponse.setSendersBalance(String.valueOf(fromAcc.getBalanceAmount()));
        moneyTransferResponse.setRecepientsBalance(String.valueOf(toAcc.getBalanceAmount()));
        moneyTransferResponse.setTransferAmount(String.valueOf(transferDetails.transferAmount));

        String jsonResult = mapper.writeValueAsString(moneyTransferResponse);
        httpServerExchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "application/json");
        httpServerExchange.getResponseSender().send(jsonResult);


      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }

    });


  }

  public TransferRequest getTransferRequest() {
    return this.transferRequest;
  }


}