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

    private  String title;
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
      return this;
    }
    public CustomerBuilder lastName(String cLastName){
      this.lastName = cLastName;
      return this;
    }

    public CustomerBuilder dob(String cDob){
      this.dob = cDob;
      return this;
    }

    public CustomerBuilder gender(String cGender){
      this.gender = cGender;
      return this;
    }
    public CustomerBuilder maritalStatus(String cMs){
      this.maritalStatus = cMs;
      return this;
    }

    public CustomerBuilder nationality(String cNat){
      this.nationality = cNat;
      return this;
    }

    public CustomerBuilder countryOfBirth(String cCountryOfBirth){
      this.countryOfBirth = cCountryOfBirth;
      return this;
    }

    public CustomerBuilder houseNumberOrName(String chs){
      this.houseNumberOrName = chs;
      return this;
    }
    public CustomerBuilder street(String cSt){
      this.street = cSt;
      return this;
    }
    public CustomerBuilder town(String cTown){
      this.town = cTown;
      return this;
    }
    public CustomerBuilder postCode(String cpc){
      this.postCode = cpc;
      return  this;
    }
    public CustomerBuilder residentialStatus(String cRes){
      this.residentialStatus = cRes;
      return this;
    }
    public CustomerBuilder contactDetails(ContactDetails cContactDetails){
      this.contactDetails = cContactDetails;
      return this;
    }


    public Customer build(){
      return new Customer(this);
    }
  }


  private Customer(CustomerBuilder builder){
    title = builder.title;
    firstName = builder.firstName;
    middleName = builder.middleName;
    lastName = builder.lastName;
    dob = builder.dob;
    gender = builder.gender;
    maritalStatus = builder.maritalStatus;
    nationality = builder.nationality;
    countryOfBirth = builder.countryOfBirth;
    houseNumberOrName = builder.houseNumberOrName;
    street = builder.street;
    town = builder.town;
    postCode = builder.postCode;
    residentialStatus = builder.residentialStatus;
    ContactDetails contactDetails = builder.contactDetails;
  }

  public String getTitle() {
    return title;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getDob() {
    return dob;
  }
}
