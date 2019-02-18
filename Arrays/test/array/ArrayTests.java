package array;


import com.java.array.ex.SecondlargetInArray;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTests {

  @Test
  public void findSecondLargest() throws Exception{
    int[] intArray = new int[]{1, 4, 5, 3};
    SecondlargetInArray secondlargetInArray = new SecondlargetInArray();
    Assert.assertEquals(4,secondlargetInArray.findSecondLargest(intArray));

  }

}
