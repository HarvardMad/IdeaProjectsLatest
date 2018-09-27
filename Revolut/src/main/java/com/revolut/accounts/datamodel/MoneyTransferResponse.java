package com.revolut.accounts.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyTransferResponse {

  @JsonProperty("transfer_amout")
  public String transferAmount;

  @JsonProperty("senders_balance")
  public String sendersBalance;

  @JsonProperty("recepients_balance")
  public String recepientsBalance;



  public MoneyTransferResponse(){

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
