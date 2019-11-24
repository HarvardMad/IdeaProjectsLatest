package com.revolut.verticles;

import com.revolut.service.CustomerService;
import com.revolut.service.CustomerServiceImpl;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class ChangeRoundUpVerticle extends AbstractVerticle {

  private CustomerService customerService;
  private MessageConsumer<JsonObject> consumer;


  @Override
  public void init(Vertx vertx, Context context) {
    super.init(vertx, context);
    customerService = new CustomerServiceImpl();
  }

  @Override

  public void start() {
    System.out.println("Deployed ChangeRoundup verticle");
    vertx.eventBus().consumer("ChangeRoundUpVerticle", message -> {
      vertx.executeBlocking(fut -> {
        // Invoke blocking code with received message data
        fut.complete(roundUpChange.apply((JsonObject) message.body()));
      }, resultHandler -> {
        if (resultHandler.succeeded()) {
         /* rquest.response().putHeader("Content-Type","application/json");
          request.response().end("{\"prasadi_trf\":\"prasadi transfer\"}");
          request.response().write(String.valueOf(requestAsJson)).end();
          System.out.println((resultHandler.result().toString()));*/

        } else {
          System.out.println("something failed");
        }


      });

    });
  }


  private Function<JsonObject,BigDecimal> roundUpChange=(transaction)->{

    BigDecimal transctionValue = new BigDecimal(transaction.getString("transaction_amount")).setScale(3);
    BigDecimal transaction_rounded_up = transctionValue.setScale(0, RoundingMode.UP).setScale(2);

    BigDecimal roundedUpDifference = transaction_rounded_up.subtract(transctionValue).setScale(2);
    return roundedUpDifference;
  };
}
