package com.revolut.accounts.dao;

import com.revolut.accounts.datamodel.CurrentAccount;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountsDAO {

  private final Map<String,CurrentAccount> accountsRepository;

  public AccountsDAO(){
    accountsRepository = new ConcurrentHashMap();
  }

  public CurrentAccount getAccount(Integer accountNumber){
    return accountsRepository.get(accountNumber);
  }

  public CurrentAccount createNewAccount(String name, double initialBalance ) {

    CurrentAccount newAccount = new CurrentAccount(name, initialBalance);

    if (null != newAccount && !accountsRepository.containsKey(newAccount.getAccountNumber())) {
      accountsRepository.put(newAccount.getAccountNumber(), newAccount);
    }
    return newAccount;

  }

  public CurrentAccount updateAccount(CurrentAccount currentAccount) {

    if (null == accountsRepository.replace(currentAccount.getAccountNumber(), currentAccount)) {
      return null;
    }
    return currentAccount;
  }

  public boolean deleteAccount(String accountNumber) {
    return null != accountsRepository.remove(accountNumber);
  }

}
