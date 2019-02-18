package com.java.array.ex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * assume both arrays
 * are equal in length
 */
public class FindIntersectionOfTwoArrays {

  /**
   * Brute force
   * @param arraOne
   * @param arrTwo
   */
  public void subArray(String[] arraOne, String[] arrTwo){
    HashSet<String> set = new HashSet<String>();
    String checkValue = null;
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0; i<arraOne.length; i++){
      checkValue = arraOne[i];
      for(int j=0; j<arrTwo.length; j++){
        if(checkValue.equalsIgnoreCase(arrTwo[j])){
          set.add(checkValue);
          break;
        }
      }
    }
    set.stream().forEach(System.out::println);
  }

  /**
   * using two hashsets
   */
  public void findInterSection(String[] a1, String[] a2){
    Set<String> setOne = new HashSet<>(Arrays.asList(a1));
    Set<String> setTwo = new HashSet<>(Arrays.asList(a2));
    setOne.retainAll(setTwo); // performs intersection

    setOne.stream().forEach(System.out::println);

  }

  public static void main(String[] args) {
    String[] inputArray1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};

    String[] inputArray2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};

    FindIntersectionOfTwoArrays findIntersectionOfTwoArrays = new FindIntersectionOfTwoArrays();

    findIntersectionOfTwoArrays.findInterSection(inputArray1,inputArray2);

  }
}
