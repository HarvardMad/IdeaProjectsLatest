package com.barclays;

public class Solution {

  private int[] A = new int[7];

  public Solution(){
    A[0] = 3;
    A[1] = 2;
    A[2] = 1;
    A[3] = 2;
    A[4] = 1;
    A[5] = 3;
    A[6] = 1;
  }
  int solution(int M, int[] A) {
    int N = A.length;
    int[] count = new int[M+1];
    for (int i = 0; i <= M; i++) {
      count[i] = 0;
    }
    int maxOccurence = 1;
    int index = -1;
    for (int i = 0; i < N; i++) {
      if (count[A[i]] > 0) {
        int tmp = count[A[i]];
        if (tmp >= maxOccurence) {
          maxOccurence = tmp;
          index = i;
        }
        count[A[i]] = tmp + 1;
      } else {
        count[A[i]] = 1;
      }
    }
    return A[index];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(4,solution.A));

  }
}