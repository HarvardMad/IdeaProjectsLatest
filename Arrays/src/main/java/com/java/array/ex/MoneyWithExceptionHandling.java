package com.java.array.ex;

import org.apache.commons.lang3.StringUtils;

public class MoneyWithExceptionHandling {

  private final int amount;
  private final String currency;

  public MoneyWithExceptionHandling(int amount, String currency) {

    if (amount < 0) {
      throw new IllegalArgumentException("amount must be greater than zero");
    }
    if (StringUtils.isEmpty(currency)) {
      throw new IllegalArgumentException("currency cannot be empty or null");
    }
    this.amount = amount;
    this.currency = currency;
  }

  public int getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public boolean equals(Object object) {
    if (object instanceof MoneyWithExceptionHandling) {
      MoneyWithExceptionHandling money = (MoneyWithExceptionHandling) object;
      return money.getCurrency() == getCurrency() && money.getAmount() == getAmount();
    }
    return false;
  }

}
