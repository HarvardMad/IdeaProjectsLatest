package com.barclays;

public class FrogJump {

  public int solution(int X, int Y, int D) {
    double d =D;
    return ((int) Math.ceil((Y - X) / d));
  }

  public static void main(String[] args) {
    FrogJump fg = new FrogJump();

    System.out.println(fg.solution(3,999111321,99));
  }
}
