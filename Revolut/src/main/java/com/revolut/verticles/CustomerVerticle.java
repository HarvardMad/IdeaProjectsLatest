package com.revolut.verticles;

import com.revolut.accounts.datamodel.Customer;
import com.revolut.service.CustomerService;
import com.revolut.service.CustomerServiceImpl;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;

public class CustomerVerticle extends AbstractVerticle {


  private CustomerService customerService;
  private MessageConsumer<JsonObject> consumer;




  @Override
  public void init(Vertx vertx, Context context) {
    super.init(vertx, context);
    customerService = new CustomerServiceImpl();
  }

  @Override

  public void start() {
    System.out.println("deployed ");
    vertx.eventBus().consumer("customerVerticle", message -> {
      vertx.executeBlocking(fut -> {
        // Invoke blocking code with received message data
        fut.complete(customerService.customerBuilder((JsonObject) message.body()));
      }, resultHandler -> {
        if (resultHandler.succeeded()) {
          System.out.println(((Customer) resultHandler.result()).getFirstName());
          vertx.eventBus().send("couchbaseVertilce",(JsonObject) message.body());
        } else {
          System.out.println("persisting customer failed");
        }


      });

    });

  }

}
