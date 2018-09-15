package com.revolut.accounts;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class CurrentAccount {
  private final String name;
  private final String accountNumber;
  private double balanceAmount;  // Total amount in bank account
  private final Lock lock = new ReentrantLock();
  private final Random number = new Random(123L);

//constructor
  public CurrentAccount(String name, double initialBalance ){
    this.balanceAmount= initialBalance;
    this.name = name;
    Random randomAccountNumberGenerator = new Random();
    int  accountNumber = randomAccountNumberGenerator.nextInt(5000) + 100;
    this.accountNumber = String.valueOf(accountNumber);
  }

  /**
   * Transfers money
   * from this to the instance argument
   * recepientsAccountNumber
   * @param recepientsAccountNumber
   * @param amount
   * @throws InterruptedException
   */
  private void transferMoneyIntoAnotherAccount(CurrentAccount recepientsAccountNumber, double amount)
      throws InterruptedException {
    while(true) {
      if (this.lock.tryLock()) {
        try {
          if (recepientsAccountNumber.lock.tryLock()) { // grab both accounts' locks before trasnfer
            try {
              if (amount > balanceAmount) {
                throw new IllegalArgumentException(
                    "There is insufficient funds in the account. The transfer cannot be made");
              }
              recepientsAccountNumber.balanceAmount += amount;
              this.balanceAmount -= amount;
              break;
            } finally {
              recepientsAccountNumber.lock.unlock();
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
       * again
       */
      Thread.sleep(1500);
    }
  }


}
