package com.revolut.accounts.datamodel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revolut.accounts.dao.AccountsDAO;
import com.revolut.exception.InvalidParamsPassedIntoMoneyTransfer;
import com.revolut.exception.TransferProcessException;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;

public class TransferHandler implements HttpHandler {

  TransferRequest transferRequest = null;
  private static final AccountsDAO accountsDAO = new AccountsDAO();

  @Override
  public void handleRequest(HttpServerExchange httpServerExchange) {

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
          throw new InvalidParamsPassedIntoMoneyTransfer(ilg.getMessage());

        }

        MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
        moneyTransferResponse.setSendersBalance(String.valueOf(fromAcc.getBalanceAmount()));
        moneyTransferResponse.setRecepientsBalance(String.valueOf(toAcc.getBalanceAmount()));
        moneyTransferResponse.setTransferAmount(String.valueOf(transferDetails.transferAmount));

        String jsonResult = mapper.writeValueAsString(moneyTransferResponse);
        httpServerExchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "application/json");
        httpServerExchange.getResponseSender().send(jsonResult);


      } catch ( IOException e) {
        throw new TransferProcessException(e.getMessage());


      }

        });


    // add a new object final




    /*CompletableFuture<CreateMoneyTransferResponse> result = service.transferMoney(transferDetails).thenApply((e) -> {
      CreateMoneyTransferResponse m =  new CreateMoneyTransferResponse(e.getEntityId());
      return m;*/
  }

  public TransferRequest getTransferRequest(){
    return this.transferRequest;
  }


}