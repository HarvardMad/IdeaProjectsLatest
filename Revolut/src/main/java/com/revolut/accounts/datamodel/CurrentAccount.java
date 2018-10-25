package com.revolut.accounts.datamodel;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public final class CurrentAccount {
  private final String name;
  private final String accountNumber;


  // Total amount in bank account:
  // No need for volatile here as lock operation ensures happens-before
  // relationships that are essential to visibility
  private double balanceAmount;

  private final Lock lock = new ReentrantLock();
  private final Random number = new Random(123L);

//constructor
  public CurrentAccount(String name, double initialBalance, String accountNumber ){
    this.balanceAmount= initialBalance;
    this.name = name;
    Random randomAccountNumberGenerator = new Random();
    this.accountNumber = accountNumber;
  }

  /**
   * return unique
   * account number
   * @return
   */
  public String getAccountNumber(){
    return this.accountNumber;
  }

  public double getBalanceAmount(){
    return this.balanceAmount;
  }


  /**
   * Transfers money
   * from this[the current object]
   * to the instance argument
   * recepientsAccountNumber
   * @param recepientsAccountNumber
   * @param amount
   * @throws InterruptedException
   */
  private String transferMoneyIntoAnotherAccount(CurrentAccount recepientsAccountNumber, double amount)
      throws InterruptedException {
    String message ="transfer complete";
    while(true) {
      if (this.lock.tryLock()) {
        try {
          if (recepientsAccountNumber.lock.tryLock()) { // grab both accounts' locks before trasnfer
            try {
              if (amount > balanceAmount) {
                message = "There is insufficient funds in the account. The transfer "
                    + "cannot be made";
                break;
              }
              recepientsAccountNumber.balanceAmount += amount;
              this.balanceAmount -= amount;

            } finally {
              recepientsAccountNumber.lock.unlock();
              break;
            }
          }
        } finally {
          this.lock.unlock();
        }
      }
      /**
       * let it rest
       * for a bit before trying
       * to acquire the locks
       * again - to avoid livelock
       */
      Thread.sleep(1500);
    }

    return message;
  }

  public static String  startMoneyTransferProcess(final CurrentAccount sendersAccount, final
  CurrentAccount receiversAccount, double transferAmount){
    String message=null;
    try {
      message = sendersAccount.transferMoneyIntoAnotherAccount(receiversAccount, transferAmount);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return message;
  }


}
