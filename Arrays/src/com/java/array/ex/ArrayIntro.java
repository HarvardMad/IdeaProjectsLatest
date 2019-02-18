package com.java.array.ex;

public class ArrayIntro {

  static int[]  arr = {1,2,3,4,5,6,7,8,9};

  public static void main(String[] args) {

    printArray();

    /**
     * rotate the values by one posistion
     * result 912345678
     */

    shiftOnePositionToTheRight();
    printArray();

  }

  protected static void printArray(){
    for(int i=0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
  }

  protected static void shiftOnePositionToTheRight(){
    int lastVal = arr[arr.length-1];
    for(int x=arr.length-1; x>0 ;x--){
      arr[x]=arr[x-1];
    }
    arr[0] = lastVal;
  }

  protected void shiftByKJumps(int jump){


  }
}
