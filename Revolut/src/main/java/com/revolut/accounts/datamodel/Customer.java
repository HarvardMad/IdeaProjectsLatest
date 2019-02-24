package com.revolut.accounts.datamodel;

/**
 * Using the builder pattern
 * as there are quite a few params to set
 */
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
  private Address address;


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

  public String getGender() {
    return gender;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public String getNationality() {
    return nationality;
  }

  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public String getHouseNumberOrName() {
    return houseNumberOrName;
  }

  public String getStreet() {
    return street;
  }

  public String getTown() {
    return town;
  }

  public String getPostCode() {
    return postCode;
  }

  public String getResidentialStatus() {
    return residentialStatus;
  }

  public ContactDetails getContactDetails() {
    return contactDetails;
  }

  /**
   * Static class for builder
   */

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
    private String residentialStatus;
    private ContactDetails contactDetails;
    private Address address;

    public CustomerBuilder title(String cTitle) {
      this.title = cTitle;
      return this;
    }

    public CustomerBuilder firstName(String cFirstName) {
      this.firstName = cFirstName;
      return this;
    }

    public CustomerBuilder middleName(String cMiddleName) {
      this.middleName = cMiddleName;
      return this;
    }

    public CustomerBuilder lastName(String cLastName) {
      this.lastName = cLastName;
      return this;
    }

    public CustomerBuilder dob(String cDob) {
      this.dob = cDob;
      return this;
    }

    public CustomerBuilder gender(String cGender) {
      this.gender = cGender;
      return this;
    }

    public CustomerBuilder maritalStatus(String cMs) {
      this.maritalStatus = cMs;
      return this;
    }

    public CustomerBuilder nationality(String cNat) {
      this.nationality = cNat;
      return this;
    }

    public CustomerBuilder countryOfBirth(String cCountryOfBirth) {
      this.countryOfBirth = cCountryOfBirth;
      return this;
    }

    public CustomerBuilder address(Address add){
      this.address = add;
      return this;
    }



    public CustomerBuilder residentialStatus(String cRes) {
      this.residentialStatus = cRes;
      return this;
    }

    public CustomerBuilder contactDetails(ContactDetails cContactDetails) {
      this.contactDetails = cContactDetails;
      return this;
    }


    public Customer build() {
      return new Customer(this);
    }
  }

  /**
   * Private constructor
   *
   * @param builder the CustomerBuilder object
   */
  private Customer(CustomerBuilder builder) {
    title = builder.title;
    firstName = builder.firstName;
    middleName = builder.middleName;
    lastName = builder.lastName;
    dob = builder.dob;
    gender = builder.gender;
    maritalStatus = builder.maritalStatus;
    nationality = builder.nationality;
    countryOfBirth = builder.countryOfBirth;
    residentialStatus = builder.residentialStatus;
    contactDetails = builder.contactDetails;
    address = builder.address;
  }


}
