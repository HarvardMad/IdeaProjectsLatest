package com.revolut.accounts.handlers;

import com.revolut.accounts.dao.AccountsDAO;
import com.revolut.accounts.datamodel.CurrentAccount;
import com.revolut.accounts.datamodel.MoneyTransferResponse;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class AllRequestHandlers {
  private static JsonObject obj=null;

  public static Handler<RoutingContext> transferHandher = (request) -> {

    obj = request.getBodyAsJson();
    String sendersAccount = String.valueOf(obj.getString("senders_account_number"));
    String recepientsAccount = String.valueOf(obj.getString("recepients_account_number"));
    final double trfAmount =  Double.parseDouble(obj.getString("transfer_amount"));

    AccountsDAO accountsDAO = initialiseData();

    Supplier<String> transferSupplierFunction = () -> {
      return CurrentAccount.startMoneyTransferProcess(accountsDAO.getAccount
        (sendersAccount),accountsDAO.getAccount
        (recepientsAccount),trfAmount);};

    Function<String, MoneyTransferResponse> responseFunction = (message) -> {
      MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
      moneyTransferResponse.setResult(message);
      return  moneyTransferResponse;
    };

    CompletableFuture<MoneyTransferResponse> transferResponseCompletableFuture = CompletableFuture.supplyAsync
        (transferSupplierFunction)
        .thenApply(responseFunction);

    JsonObject message = new JsonObject();
    try {
      message.put("result",transferResponseCompletableFuture.get().getResult());
      message.put("senders_account_updated",accountsDAO.getAccount(sendersAccount).getBalanceAmount());
      message.put("receivers_account_updated",accountsDAO.getAccount(recepientsAccount).getBalanceAmount());
    } catch (InterruptedException e) {
      e.printStackTrace();//will use loggers later!
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    request.response().putHeader("Content-Type","application/json").end(message.encodePrettily());
  };

  public static Handler<RoutingContext> newAccountHandher = (request) -> {

    obj = request.getBodyAsJson();
    String sendersAccount = String.valueOf(obj.getString("senders_account_number"));
    String recepientsAccount = String.valueOf(obj.getString("recepients_account_number"));
    double trfAmount =  Double.parseDouble(obj.getString("transfer_amount"));


    request.response().putHeader("Content-Type","application/json");
    request.response().end("{\"prasadi_trf\":\"prasadi transfer\"}");
    request.response().write(String.valueOf(obj)).end();
  };

  public static Handler<RoutingContext> requestHandler = (request) -> request.response().end("Hello");

  public static AccountsDAO initialiseData(){
    AccountsDAO accountsDAO = new AccountsDAO();

    accountsDAO.createNewAccount("Adam", 400.00, "12345");
    accountsDAO.createNewAccount("Zac", 250.00, "54321");

    return accountsDAO;
  }


}
