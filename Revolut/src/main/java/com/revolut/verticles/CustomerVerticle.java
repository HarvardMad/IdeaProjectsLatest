package com.revolut.verticles;

import com.google.inject.Inject;
import com.revolut.service.CustomerService;
import com.revolut.service.CustomerServiceImpl;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

public class CustomerVerticle extends AbstractVerticle {

  @Inject
  private CustomerService customerService;

  @Inject
  public CustomerVerticle(){
  }

  @Override

  public void start(Future<Void> startFuture) {
    vertx.eventBus().consumer("customerVerticle", message -> {

      vertx.executeBlocking(fut -> {
        // Invoke blocking code with received message data
        fut.complete(new CustomerServiceImpl().customerBuilder((JsonObject) message.body()));
      }, false, ar -> { // ordered == false
        // Handle result, e.g. reply to the message
      });
      customerService.customerBuilder((JsonObject)message.body());

    });

  }

}
