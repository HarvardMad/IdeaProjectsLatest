package com.barclays;

public class SolutionTwo {

  private int[] A = new int[6];

  public SolutionTwo() {

    A[0] = 3;
    A[1] = 5;
    A[2] = 6;
    A[3] = 3;
    A[4] = 3;
    A[5] = 5;

  }

  public int solution(int[] A) {
    int currentValue = -1;
    int identicalPairs = 0;
    int startIndex = 0;
    for (int i = 0; i < A.length; i++) {
      currentValue = A[i];
      startIndex = i;
      for (int j = i + 1; j < A.length; j++) {
        if (currentValue == A[j] && j > i) {
          identicalPairs += 1;
        }
      }
    }
    return identicalPairs;
  }

  public static void main(String[] args) {
    SolutionTwo s2 = new SolutionTwo();
    int result = s2.solution(s2.A);
    System.out.println(result);
  }

}
