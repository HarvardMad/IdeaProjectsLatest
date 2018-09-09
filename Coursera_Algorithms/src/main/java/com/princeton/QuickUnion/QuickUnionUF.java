package com.princeton.QuickUnion;

import java.util.stream.IntStream;
import org.apache.commons.lang.time.*;


public class QuickUnionUF {

  private int[] id=null;

  public QuickUnionUF(int N){
    id = new int[N];
    IntStream.rangeClosed(0,N-1).forEach(i -> id[i]=i);
  }

  private int root(int i){
  StopWatch tw = new StopWatch();
    while( i != id[i])
      i = id[i];
    tw.getTime();
    return i;

  }

  public boolean connected(int p, int q){
    return root(p) == root(q);
  }

  public void union(int p, int q){
    int rootOfP = root(p);
    int rootOfq = root(q);

    id[rootOfP]=rootOfq;

  }

}
