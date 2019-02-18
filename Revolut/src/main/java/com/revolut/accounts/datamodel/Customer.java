package com.revolut.accounts.datamodel;

public class Customer {

  private String title;
  private String firstName;
  private String middleName;
  private String lastName;
  private String dob;
  private String gender;
  private String maritalStatus;
  private String nationality;
  private String countryOfBirth;
  private String houseNumberOrName;
  private String street;
  private String town;
  private String postCode;
  private String residentialStatus;
  private ContactDetails contactDetails;


  public static class CustomerBuilder {

    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String countryOfBirth;
    private String houseNumberOrName;
    private String street;
    private String town;
    private String postCode;
    private String residentialStatus;
    ContactDetails contactDetails;

    public CustomerBuilder title(String cTitle) {
      this.title = cTitle;
      return this;
    }

    public CustomerBuilder firstName(String cFirstName){
      this.firstName = cFirstName;
      return this;
    }
    public CustomerBuilder middleName(String cMiddleName){
      this.middleName= cMiddleName;
    }
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder
    public CustomerBuilder

    public Customer build(){
      return new Customer(this);
    }
  }


  private Customer(CustomerBuilder builder){
    title;
    firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String countryOfBirth;
    private String houseNumberOrName;
    private String street;
    private String town;
    private String postCode;
    private String residentialStatus;
    private ContactDetails contactDetails;
  }

}
