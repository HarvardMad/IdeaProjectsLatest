package stringreverse;

import com.java.array.stringreverse.StringReverse;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {

  private final Object[] getStrings(){
    return new Object[]{new Object[]{"abcde","edcba"},
    new Object[]{"xyz","zyx"}};
  }

  private final Object[] getNullOrEmptyStrings(){
    return new Object[]{new Object[]{""},
        new Object[]{null}};
  }

  @Test(expected=IllegalArgumentException.class)
  @Parameters(method = "getNullOrEmptyStrings")
  public void testThatExceptionThrows(String str) throws Exception{
    StringReverse reverse = new StringReverse();
    reverse.inRev(str);
  }

  @Test
  @Parameters(method = "getStrings")
  public void testReverseStringWorks(String str, String rev){

    StringReverse reverse = new StringReverse();
    Assert.assertEquals(rev, reverse.inRev(str));
  }
}
