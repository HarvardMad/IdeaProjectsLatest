package parameterisedtests;

import com.java.array.ex.Money;
import org.junit.Assert;
import org.junit.Test;

public class TestMoney {

  @Test
  public void testThatConstructorSetsMoneyAndCurrency() throws Exception{

    final int amt=100;
    final String currency="GBP";
    Money money = new Money(amt,currency);
    Assert.assertEquals(currency,money.getCurrency());
    Assert.assertEquals(amt,money.getAmount());

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
