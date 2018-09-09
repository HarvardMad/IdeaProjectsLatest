package com.princeton.unionfind;

import java.util.stream.IntStream;

public class QuickFind {

  public int[] getId() {
    return id;
  }

  private int[] id =null;


    public QuickFind(int N){

        id = new int[N];
        IntStream.rangeClosed(0,N-1).forEach(i -> id[i]=i);

    }

  /**
   * are p and q in the same set?
   * @param p
   * @param q
   * @return
   */

    public boolean find(int p, int q){
      return id[p] == id[q];
    }

  /**
   * replace sets containing p and q
   * with their union
   *
   * @param p
   * @param q
   */
    public void unite(int p, int q) {
     int idOfP = id[p];
     for(int i=0; i<=id.length-1;i++){
       if(id[i]==idOfP) {
         id[i]=id[q];
       }

      }

    }
}
