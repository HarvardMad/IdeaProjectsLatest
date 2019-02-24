package com.revolut.accounts.datamodel;

public class Address {
  private String houseNumberOrName;
  private String street;
  private String town;
  private String postCode;
  private  String county;

  public String getHouseNumberOrName() {
    return houseNumberOrName;
  }

  public void setHouseNumberOrName(String houseNumberOrName) {
    this.houseNumberOrName = houseNumberOrName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }
}
