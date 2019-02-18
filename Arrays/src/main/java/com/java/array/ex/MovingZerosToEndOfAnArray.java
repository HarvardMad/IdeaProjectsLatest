package com.java.array.ex;

import java.util.Arrays;

public class MovingZerosToEndOfAnArray {


  public void moveZeros(int[] a1) {
    int[] result = new int[a1.length];

    int indexCounter = 0;
    for (int i = 0; i < a1.length; i++) {
      if (a1[i] != 0) {
        result[indexCounter] = a1[i];
        indexCounter++;

      }

    }
    System.out.println("Before : ");
    Arrays.stream(a1).forEach(System.out::println);
    System.out.println("After : ");
    Arrays.stream(result).forEach(System.out::println);
  }


  public void moveZerosToTheFront(int[] a1) {
    int[] result = new int[a1.length];

    int indexCounter = 0;
    for (int i = 0; i < a1.length; i++) {
      if (a1[i] != 0) {
        result[indexCounter] = a1[i];
        indexCounter++;

      }

    }
    System.out.println("Before : ");
    Arrays.stream(a1).forEach(System.out::println);
    System.out.println("After : ");
    Arrays.stream(result).forEach(System.out::println);
  }
  public static void main(String[] args) {

    int[] a1 = new int[] {12, 0, 7, 0, 8, 0, 3};
    int[] a2 = new int[] {1, -5, 0, 0, 8, 0, 1};
    int[] a3 = new int[] {1, -5, 0, 0, 8, 0, 1};

    MovingZerosToEndOfAnArray movingZerosToEndOfAnArray = new MovingZerosToEndOfAnArray();
    movingZerosToEndOfAnArray.moveZeros(a3);
  }

}
