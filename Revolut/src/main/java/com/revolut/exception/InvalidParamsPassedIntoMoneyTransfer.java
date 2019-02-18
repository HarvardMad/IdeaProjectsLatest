package com.revolut.exception;

public class InvalidParamsPassedIntoMoneyTransfer extends RuntimeException {

public InvalidParamsPassedIntoMoneyTransfer(String msg){
  super(msg);
}

  public InvalidParamsPassedIntoMoneyTransfer(String msg, Throwable cause){
    super(msg, cause);
  }

}
