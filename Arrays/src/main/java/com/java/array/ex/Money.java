package com.java.array.ex;

public class Money {
  private final int amount;
  private final String currency;

  public Money(int amount, String currency){

    this.amount = amount;
    this.currency = currency;
  }

  public int getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public boolean equals(Object object){
    if(object instanceof Money){
      Money money = (Money)object;
      return money.getCurrency() == getCurrency() && money.getAmount() == getAmount();
    }
    return false;
  }

}
