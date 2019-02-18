package com.revolut.service;

import com.revolut.accounts.datamodel.Customer;
import io.vertx.core.json.JsonObject;

public interface CustomerService {
  Customer customerBuilder(JsonObject newCustomerObject);

}
