package com.princeton.binarysearch;

import java.util.stream.IntStream;

/**
 * Here's a step-by-step description of using binary search to play the guessing game:
 Let min = 1 min=1m, i, n, equals, 1 and max = nmax=nm, a, x, equals, n.
 Guess the average of maxmaxm, a, x and minminm, i, n, rounded down so that it is an integer.
 If you guessed the number, stop. You found it!
 If the guess was too low, set minminm, i, n to be one larger than the guess.
 If the guess was too high, set maxmaxm, a, x to be one smaller than the guess.
 Go back to step two.
 */
 class BinarySearch {
  private int[] intArray = null;

  public BinarySearch(int N){

    intArray = new int[N];
    IntStream.range(0,N)
        .forEach(i->intArray[i]= i+1);
    /**
     * new Random()
     .ints(0,N*100).sorted()
     .findFirst()
     .getAsInt());
     */

  }

  public int searchUsingBinarySearch(int searchNumber, int min, int max ){

    //Arrays.stream(intArray).forEach(System.out::println);

    if(min<=max) {
      int middle = (min + max) / 2;
      if (intArray[middle] == searchNumber)
        return middle;
      else if (searchNumber > intArray[middle]) {
        min = middle + 1;
        return searchUsingBinarySearch(searchNumber, min, max);
      }
      else if (searchNumber < intArray[middle]) {
        max = middle-1;
        return searchUsingBinarySearch(searchNumber, min, max);
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    BinarySearch bs = new BinarySearch(10);
    int search = 259;//bs.intArray[1];
    int min = 0;
    int max = bs.intArray.length-1;
    int result = bs.searchUsingBinarySearch(search, min, max);
    if (result == -1)
      System.out.println("search item " + search + " not found");
    else
      System.out.println("search item " + search + " found at location " + bs.searchUsingBinarySearch(search, min, max));
  }

}
