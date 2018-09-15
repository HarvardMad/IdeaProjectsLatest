package com.barclays;

public class CyclicArray {
  public int[] solution(int[] A, int K) {
    int lastElement = A[A.length-1];

    if(A.length==0)
      return A;

    for(int i=1; i<=K; i++){
      for(int j=A.length-1; j>0;j--)
        A[j]=A[j-1];
      A[0]=lastElement;
      lastElement =A[A.length-1];
    }

    return A;
  }

  public static void main(String[] args) {

    int[]A = new int[]{1, 2, 3, 4};
    CyclicArray cyclicArray=new CyclicArray();
    A = cyclicArray.solution(A,4);
    for(int b:A){
      System.out.println(b);
    }
  }
}
