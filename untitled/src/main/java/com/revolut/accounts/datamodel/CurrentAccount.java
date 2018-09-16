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
  public CurrentAccount(String name, double initialBalance ){
    this.balanceAmount= initialBalance;
    this.name = name;
    Random randomAccountNumberGenerator = new Random();
    int  accountNumber = randomAccountNumberGenerator.nextInt(5000) + 100;
    this.accountNumber = String.valueOf(accountNumber);
  }

  /**
   * return unique
   * account number
   * @return
   */
  public String getAccountNumber(){
    return this.accountNumber;
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
       * again - to avoid livelock
       */
      Thread.sleep(1500);
    }
  }

  public static void startMoneyTransferProcess(final CurrentAccount sendersAccount, final CurrentAccount
      receiversAccount, double transferAmount){
    //Runnable to execute the logic
    Runnable moneyTransfer = () -> {
      try {
        sendersAccount.transferMoneyIntoAnotherAccount(receiversAccount, transferAmount);
      }catch(InterruptedException  ie){
        ie.printStackTrace();
        //Something went wrong: Interrupt the current process
        Thread.currentThread().interrupt();
      }
    };

    Thread moneyTransferThread = new Thread(moneyTransfer);
    moneyTransferThread.start();
  }


}
