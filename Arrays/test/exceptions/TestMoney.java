package exceptions;


import com.java.array.ex.Money;
import com.java.array.ex.MoneyWithExceptionHandling;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This test class tests that exceptions are thrown
 * when invalid args are passed to the method
 * Note that there are no assertions, because
 * the expected attribute of the @Test annotation
 * implicitly creates a try-catchand this is added
 * automatically by Junit
 */
@RunWith(JUnitParamsRunner.class)
public class TestMoney {

  private static final Object[] getMoney(){

    return new Object[] { new Object[]{-100,"GBP"},
        new Object[]{200,null},
        new Object[]{300,""}};
  }
  @Test(expected = IllegalArgumentException.class)
  @Parameters(method="getMoney")
  public void testThatConstructorSetsMoneyAndCurrency(int amount,String currency) throws Exception{

    MoneyWithExceptionHandling money = new MoneyWithExceptionHandling(amount,currency);

  }

  @Test
  public void testForEquality() throws Exception{

    final int amt=100;
    final String currency="GBP";
    Money moneyOne = new Money(amt,currency);
    Money moneyTwo = new Money(amt,currency);
    Assert.assertTrue(moneyOne.equals(moneyTwo));
  }
}

