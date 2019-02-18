package com.revolut.exception;

public class TransferProcessException extends RuntimeException {

  public TransferProcessException(String msg){
    super(msg);
  }

  public TransferProcessException(String msg, Throwable cause){
    super(msg, cause);
  }

}
