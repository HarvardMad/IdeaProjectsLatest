package com.revolut.service;

import com.google.inject.Singleton;
import com.revolut.accounts.datamodel.Address;
import com.revolut.accounts.datamodel.ContactDetails;
import com.revolut.accounts.datamodel.Customer;
import io.vertx.core.json.JsonObject;
import java.util.UUID;

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

    JsonObject jsonObject = persistInCouchBase(newCustomerObject);
    return persistCustomerInPostGres(newCustomerObject);
  }

  private Customer persistCustomerInPostGres(JsonObject newCustomerObject){

    JsonObject contactDetailsJson = newCustomerObject.getJsonObject("contact_details");
    ContactDetails contactDetails = new ContactDetails(String.valueOf(contactDetailsJson.getString("email")),
        String.valueOf(contactDetailsJson.getString("mobile_phone")),
        String.valueOf(contactDetailsJson.getString("home_number")),
        String.valueOf(contactDetailsJson.getString("work_number")));

    JsonObject addressJson = newCustomerObject.getJsonObject("address");
    Address address = new Address();
    address.setCounty( String.valueOf(addressJson.getString("county")));
    address.setHouseNumberOrName(String.valueOf(addressJson.getString("house_no_or_name")));
    address.setStreet(String.valueOf(addressJson.getString("street")));
    address.setTown(String.valueOf(addressJson.getString("town")));
    address.setPostCode(String.valueOf(addressJson.getString("post_code")));

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
        .residentialStatus(String.valueOf(newCustomerObject.getString("residential_status")))
        .contactDetails(contactDetails)
        .address(address)
        .build();
  }

  private JsonObject persistInCouchBase(JsonObject newCustomerObject){
    /* couchbase persistence */
    String couchbaseCustomerDocumentId  = UUID.randomUUID().toString();
    newCustomerObject.put("customer_id",couchbaseCustomerDocumentId);
    return newCustomerObject;
  }
}
