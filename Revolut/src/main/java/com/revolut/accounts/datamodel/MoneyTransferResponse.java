package com.revolut.accounts.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyTransferResponse {

  @JsonProperty("transfer_amout")
  private String transferAmount;

  @JsonProperty("senders_balance")
  private String sendersBalance;

  @JsonProperty("recepients_balance")
  private String recepientsBalance;

  private String result;


  public MoneyTransferResponse(){

  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getTransferAmount() {
    return transferAmount;
  }

  public void setTransferAmount(String transferAmount) {
    this.transferAmount = transferAmount;
  }

  public String getSendersBalance() {
    return sendersBalance;
  }

  public void setSendersBalance(String sendersBalance) {
    this.sendersBalance = sendersBalance;
  }

  public String getRecepientsBalance() {
    return recepientsBalance;
  }

  public void setRecepientsBalance(String recepientsBalance) {
    this.recepientsBalance = recepientsBalance;
  }



}
