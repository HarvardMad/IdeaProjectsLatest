package com.revolut.exception;

public class ServerFailedToStartException extends RuntimeException {

  public ServerFailedToStartException(String message){
    super(message);
  }
}
