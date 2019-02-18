package com.revolut.accounts.handlers;

import com.revolut.accounts.dao.AccountsDAO;
import com.revolut.accounts.datamodel.CurrentAccount;
import com.revolut.accounts.datamodel.MoneyTransferResponse;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * The router is the cornerstone of Vert.x Web.
 * This object is responsible for dispatching the HTTP requests to the right handler.
 * Two other concepts are very important in Vert.x Web:
 * Routes - which let you define how request are dispatched
 * Handlers - which are the actual action processing the requests and writing the result.
 * Handlers can be chained.
 * If you understand these 3 concepts, you have understood everything in Vert.x Web.
 */
public class AllRequestHandlers {
  private static JsonObject requestAsJson=null;
  private static AccountsDAO accountsDAO = initialiseData();

  public  Handler<RoutingContext> transferHandher = (request) -> {

    requestAsJson = request.getBodyAsJson();
    request.vertx().eventBus().send("customer",requestAsJson);
    String sendersAccount = String.valueOf(requestAsJson.getString("senders_account_number"));
    String recepientsAccount = String.valueOf(requestAsJson.getString("recepients_account_number"));
    final double trfAmount =  Double.parseDouble(requestAsJson.getString("transfer_amount"));

    Supplier<String> transferSupplierFunction = () -> CurrentAccount.startMoneyTransferProcess(accountsDAO.getAccount
      (sendersAccount),accountsDAO.getAccount
      (recepientsAccount),trfAmount);


     ExecutorService executorService = Executors.newSingleThreadExecutor();

    Function<String, MoneyTransferResponse> responseFunction = (message) -> {
      MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
      moneyTransferResponse.setResult(message);
      return  moneyTransferResponse;
    };

    CompletableFuture<MoneyTransferResponse> transferResponseCompletableFuture = CompletableFuture.supplyAsync
        (transferSupplierFunction,executorService)
        .thenApply(responseFunction);

    JsonObject message = new JsonObject();
    try {
      message.put("result",transferResponseCompletableFuture.get().getResult());
      message.put("senders_account_updated",accountsDAO.getAccount(sendersAccount).getBalanceAmount());
      message.put("receivers_account_updated",accountsDAO.getAccount(recepientsAccount).getBalanceAmount());
      request.vertx().eventBus().send("transfer",message);
      request.response().putHeader("Content-Type","application/json").end(message.encodePrettily());
    } catch (InterruptedException e) {
      e.printStackTrace();//will use loggers later!
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    finally {
      executorService.shutdown();
    }


  };

  public  Handler<RoutingContext> newAccountHandher = (request) -> {

    requestAsJson = request.getBodyAsJson();
    request.vertx().eventBus().send("customerVerticle",requestAsJson);
  };

  /**
   * Type in the Name of the person
   * or company (Up to 18 characters. Acceptable special characters are '/', '&' and '-'.)
   Type in their bank account number
   Type in their sort code
   Type in a reference - this should be something to
   help identify you to the payee (Up to 18 characters.
   Acceptable special characters are '/', '&' and '-'.)
   */
  public  Handler<RoutingContext> newPayeeHandher = (request) -> {

    requestAsJson = request.getBodyAsJson();
    String firstName = String.valueOf(requestAsJson.getString("payee_name"));
    String lastName = String.valueOf(requestAsJson.getString("payee_bank_account"));
    String dob =  String.valueOf(requestAsJson.getString("payee_sort_code"));
    String houseNumberOrName = String.valueOf(requestAsJson.getString("payee_reference"));

    request.response().putHeader("Content-Type","application/json");
    request.response().end("{\"prasadi_trf\":\"prasadi transfer\"}");
    request.response().write(String.valueOf(requestAsJson)).end();
  };
  public static Handler<RoutingContext> requestHandler = (request) -> request.response().end("Hello");

  public static AccountsDAO initialiseData(){
    AccountsDAO accountsDAO = new AccountsDAO();

    accountsDAO.createNewAccount("Adam", 400.00, "12345");
    accountsDAO.createNewAccount("Zac", 500.00, "54321");

    return accountsDAO;
  }


}
