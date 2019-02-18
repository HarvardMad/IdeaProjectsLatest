package com.java.array.ex;

public class SecondlargetInArray {

  static int[] intArray = new int[]{1, 4, 5, 3};


  public static void main(String[] args) {
    SecondlargetInArray secondlargetInArray = new SecondlargetInArray();
    int s_largest = secondlargetInArray.findSecondLargest(intArray);
    System.out.println(s_largest);
  }

  public int findSecondLargest(int[] arr) {
    int f_largest = intArray[0];
    int s_largest = intArray[0];

    for (int i = 1; i < intArray.length; i++) {
      int current = intArray[i];
      if (current > f_largest) {
        s_largest = f_largest;
        f_largest = current;
      }
    }
    return s_largest;
  }
}
