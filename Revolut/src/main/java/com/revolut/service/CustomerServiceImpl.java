package com.revolut.service;

import com.revolut.accounts.datamodel.ContactDetails;
import com.revolut.accounts.datamodel.Customer;
import io.vertx.core.json.JsonObject;

public class CustomerServiceImpl implements CustomerService{

  String title;
  String firstName;
  String middleName;
  String lastName;
  String dob;
  String gender;
  String maritalStatus;
  String nationality;
  String countryOfBirth;
  String houseNumberOrName;
  String street;
  String town;
  String postCode;
  String residentialStatus;
  ContactDetails contactDetails;

  public Customer customerBuilder(JsonObject newCustomerObject) {

    title = String.valueOf(newCustomerObject.getString("first_name"));
    firstName = String.valueOf(newCustomerObject.getString("first_name"));
    middleName = String.valueOf(newCustomerObject.getString("middle_name"));
    lastName = String.valueOf(newCustomerObject.getString("last_name"));
    dob = String.valueOf(newCustomerObject.getString("date_of_birth"));
    gender = String.valueOf(newCustomerObject.getString("gender"));
    maritalStatus = String.valueOf(newCustomerObject.getString("marital_status"));
    nationality = String.valueOf(newCustomerObject.getString("marital_status"));

    countryOfBirth = String.valueOf(newCustomerObject.getString("birth_country"));
    houseNumberOrName = String.valueOf(newCustomerObject.getString("house_no_or_name"));
    street = String.valueOf(newCustomerObject.getString("street"));
    town = String.valueOf(newCustomerObject.getString("town"));
    postCode = String.valueOf(newCustomerObject.getString("post_code"));
    residentialStatus = String.valueOf(newCustomerObject.getString("residential_status"));
    contactDetails = new ContactDetails(String.valueOf(newCustomerObject.getString("email")),
        String.valueOf(newCustomerObject.getString("mobile_phone")),
        String.valueOf(newCustomerObject.getString("home_number")),
        String.valueOf(newCustomerObject.getString("work_number")));

    return new Customer();
  }

}
