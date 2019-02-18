package com.revolut.accounts.datamodel;

public class ContactDetails {

  private String email;
  private String mobileNumber;
  private String homeNumber;
  private String workNumber;


  public ContactDetails(final String email, final String mobileNumber, final String homeNumber, final String
      workNumber){

    this.email = email;
    this.mobileNumber = mobileNumber;
    this.homeNumber = homeNumber;
    this.workNumber = workNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public void setMobileNumber(final String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public void setHomeNumber(final String homeNumber) {
    this.homeNumber = homeNumber;
  }

  public String getWorkNumber() {
    return workNumber;
  }

  public void setWorkNumber(final String workNumber) {
    this.workNumber = workNumber;
  }
}
