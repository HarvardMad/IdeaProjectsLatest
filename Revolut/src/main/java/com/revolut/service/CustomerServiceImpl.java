package com.revolut.service;

import com.google.inject.Singleton;
import com.revolut.accounts.datamodel.ContactDetails;
import com.revolut.accounts.datamodel.Customer;
import io.vertx.core.json.JsonObject;

/**
 * It is a form of the Builder pattern [Gamma95, p. 97].
 * Instead of making the desired object directly,
 * the client calls a constructor (or static factory) with all of the required parameters
 * and gets a builder object.
 * Then the client calls setter-like methods on the builder object to
 * set each optional parameter of interest.
 * Finally, the client calls a parameterless build method to generate the object,
 * which is immutable. The builder is a static member class (Item 22) of the class it builds.
 */
@Singleton
public class CustomerServiceImpl implements CustomerService {


  public Customer customerBuilder(JsonObject newCustomerObject) {

    ContactDetails contactDetails = new ContactDetails(String.valueOf(newCustomerObject.getString("email")),
        String.valueOf(newCustomerObject.getString("mobile_phone")),
        String.valueOf(newCustomerObject.getString("home_number")),
        String.valueOf(newCustomerObject.getString("work_number")));

    return new Customer.CustomerBuilder()
        .title(String.valueOf(newCustomerObject.getString("title")))
        .firstName(String.valueOf(newCustomerObject.getString("first_name")))
        .middleName(String.valueOf(newCustomerObject.getString("middle_name")))
        .lastName(String.valueOf(newCustomerObject.getString("last_name")))
        .dob(String.valueOf(newCustomerObject.getString("dob")))
        .gender(String.valueOf(newCustomerObject.getString("gender")))
        .maritalStatus(String.valueOf(newCustomerObject.getString("marital_status")))
        .nationality(String.valueOf(newCustomerObject.getString("nationality")))
        .countryOfBirth(String.valueOf(newCustomerObject.getString("birth_country")))
        .houseNumberOrName(String.valueOf(newCustomerObject.getString("house_no_or_name")))
        .street(String.valueOf(newCustomerObject.getString("street")))
        .town(String.valueOf(newCustomerObject.getString("town")))
        .postCode(String.valueOf(newCustomerObject.getString("post_code")))
        .residentialStatus(String.valueOf(newCustomerObject.getString("residential_status")))
        .contactDetails(contactDetails)
        .build();
  }
}
