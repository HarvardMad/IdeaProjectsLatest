package parameterisedtests;

import com.java.array.ex.Money;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(JUnitParamsRunner.class)
public class TestMoneyParameterised {

  private static final Object[] getMoney() {
    return new Object[]{
        new Object[]{100, "USD"},
        new Object[]{200, "GBP"},
        new Object[]{300, "LKR"},
        new Object[]{400, "EUR"}
    };
  }

  /**
   * Test uses the params array
   */
  @Test
  @Parameters(method = "getMoney")
  public void testConstructorShouldTestAmountAndCurrency(int amount,
      String currency) {

    Money money = new Money(amount, currency);
    Assert.assertEquals(amount, money.getAmount());
    Assert.assertEquals(currency, money.getCurrency());
  }
}
