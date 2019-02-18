//package java;

import com.revolut.accounts.dao.AccountsDAO;
import com.revolut.accounts.datamodel.CurrentAccount;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RevolutTests {
  private static final AccountsDAO accountsDAO = new AccountsDAO();

  @Before
  public void init(){
    accountsDAO.createNewAccount("Adam",400.00,"12345");
    accountsDAO.createNewAccount("Zac",250.23,"54321");
  }

  @Test
  public void happy_path() throws InterruptedException, IOException{
    CurrentAccount from = accountsDAO.getAccount("12345");
    CurrentAccount to = accountsDAO.getAccount("54321");
    CurrentAccount.startMoneyTransferProcess(from,to,100.00);
    Assert.assertEquals(300.00,from.getBalanceAmount(),000.00);
    Assert.assertEquals(350.23,to.getBalanceAmount(),000.00);


  }

}
