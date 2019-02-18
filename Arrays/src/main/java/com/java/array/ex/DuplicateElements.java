package com.java.array.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class DuplicateElements {


  static List<String> duplicatesList = new ArrayList<>();

  public static void main(String[] args) {

    String[] strArray = new String[]{"Java", "Java", "Spring", "Hibernate", "Guice", "Spring"};
    int[] intArray = new int[]{5,2,4,1,6,7,8};
    int[] anArray = new int[] {12, 13, 40, 15, 8, 10, -15};
    int[] thirdArray = new int[]{12, 23, 125, 41, -75, 38, 27, 11};


    DuplicateElements duplicateElements = new DuplicateElements();
   /* duplicatesList = duplicateElements.findDuplicateStrings(strArray);
    duplicatesList.stream().forEach(System.out::println);*/

    duplicateElements.findpairs(thirdArray,50);
  }

  public List<String> findDuplicateStrings(String[] strArray){

    List<String> duplicatesList = new ArrayList<>();
    Set<String> noduplicates = new HashSet<>();
    Consumer<String> removeDuplicates =(String str) -> {
      if(noduplicates.contains(str)){
        duplicatesList.add(str);
      }else{
        noduplicates.add(str);
      }
    };
    Arrays.stream(strArray).forEach(str->removeDuplicates.accept(str));
    return duplicatesList;
  }

  /**
   * Input Array: new int[]{5,2,4,1,6,7,8};
   * 5 + 4 = 9
   2 + 7 = 9
   1 + 8 = 9

   * Input Array : [12, 13, 40, 15, 8, 10, -15]
   Input Number : 25
   Pairs of elements whose sum is 25 are :
   12 + 13 = 25
   40 + -15 = 25
   15 + 10 = 25
   * @param intArray
   * @param num
   */
  public void findpairs(int[] intArray, int num){
    int counter=0;
    while (counter != intArray.length){
      int startValue = intArray[counter];
      for(int i=counter+1; i<intArray.length ; i ++){
        if(startValue +intArray[i]== num){
          System.out.println(startValue + " + " + intArray[i] + " = " + Integer.valueOf(startValue +intArray[i]));
        }
      }

      counter ++;
    }

  }

}
