package com.princeton.unionfind;

public class QuickFindRunner {

  public static void main(String[] args) {
int N =10;
    QuickFind qf = new QuickFind(10);
    System.out.println("Is union (1 , 5) ? " + qf.find(1,5));

    System.out.println("join 1 and 5" );
    qf.unite(1,5);

    System.out.println("Is union (1 , 5) ? " + qf.find(1,5));

  for(int i=0; i<N; i++){
    System.out.println(i + " -> " + String.valueOf(qf.getId()[i]));
  }
    System.out.println("**************************");

    qf.unite(3,5);


    for(int i=0; i<N; i++){
      System.out.println(i + " -> " + String.valueOf(qf.getId()[i]));
    }
    System.out.println("**************************");
  }

}
