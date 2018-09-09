package com.barclays;

public class TennisMatch {

  public int solution(int P, int C) {
    // write your code in Java SE 8
    int courts = 0;
    int players = 0;
    int groups = 0;
    int remainder = 0;

    if (P == 0 || C == 0) {
      return 0;
    }

    for (int i = 0; i <= C; i++) {
      groups = P / C;
      remainder = P % C;

    }

    return remainder;
  }

  public static void main(String[] args) {
    TennisMatch tm = new TennisMatch();
    System.out.println(tm.solution(5, 3));
  }

}
