package com.barclays;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysStuff {

  private int[] a = new int[10];
  private char[] charA = new char[]{'a','d','b','w','x','t'};

  public ArraysStuff(){
    IntStream.range(0,10).forEach(i->a[i]=i);
    Arrays.sort(charA);
    IntStream.range(0,6).forEach(i-> System.out.println(charA[i]));
    String joined =IntStream.range(0,6).mapToObj(i->String.valueOf(charA[i])).collect(Collectors.joining(",","{",
        "}"));
    System.out.println("joined " + joined);

  }
  public static void main(String[] args) {
    ArraysStuff as = new ArraysStuff();

  }

}
