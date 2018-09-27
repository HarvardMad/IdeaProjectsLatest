package com.revolut.accounts.datamodel;

public class TransferDetails {

  public double transferAmount;

  public String sendersAccountNumber;

  public String recepientsmAccountNumber;

  public TransferDetails(String from, String to, double trfAmt){

    this.sendersAccountNumber = from;
    this.recepientsmAccountNumber = to;
    this.transferAmount = trfAmt;
  }

  public double getTransferAmount() {
    return transferAmount;
  }

  public void setTransferAmount(double transferAmount) {
    this.transferAmount = transferAmount;
  }

  public String getSendersAccountNumber() {
    return sendersAccountNumber;
  }

  public void setSendersAccountNumber(String sendersAccountNumber) {
    this.sendersAccountNumber = sendersAccountNumber;
  }

  public String getRecepientsmAccountNumber() {
    return recepientsmAccountNumber;
  }

  public void setRecepientsmAccountNumber(String recepientsmAccountNumber) {
    this.recepientsmAccountNumber = recepientsmAccountNumber;
  }

}
