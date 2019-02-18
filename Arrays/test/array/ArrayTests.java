package array;


import com.java.array.ex.DuplicateElements;
import com.java.array.ex.SecondlargetInArray;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTests {

  @Test
  public void findSecondLargest() throws Exception{
    int[] intArray = new int[]{1, 4, 5, 3};
    SecondlargetInArray secondlargetInArray = new SecondlargetInArray();
    Assert.assertEquals(4,secondlargetInArray.findSecondLargest(intArray));

  }

  @Test
  public void findDuplicates() throws Exception{

    String[] strArray = new String[]{"Java", "Java", "Spring", "Hibernate", "Guice", "Spring"};
    List<String> duplicates;
    DuplicateElements duplicateElements = new DuplicateElements();
    duplicates = duplicateElements.findDuplicateStrings(strArray);
    Assert.assertTrue(duplicates.contains("Java"));
    Assert.assertTrue(duplicates.contains("Spring"));
  }

}
