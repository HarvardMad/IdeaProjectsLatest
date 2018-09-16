package com.revolut.accounts.datamodel;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentAccountRequest {

  @JsonProperty("transfer_amout")
  public String transferAmount;

  @JsonProperty("senders_account_number")
  public String sendersAccountNumber;

  @JsonProperty("recepients_account_number")
  public String recepientsmAccountNumber;

  public String getTransferAmount() {
    return transferAmount;
  }

  public void setTransferAmount(String transferAmount) {
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
