package com.java.array.stringreverse;

import org.apache.commons.lang3.StringUtils;

public class StringReverse {

  private final String str = "abcdef";

  public String inRev(String str){

    if(StringUtils.isEmpty(str))
      throw new IllegalArgumentException("invalid input");

    char[] strings = str.toCharArray();
    StringBuilder revBuilder = new StringBuilder();
    for(int i=strings.length-1; i>=0; i--){
      revBuilder.append(strings[i]);
    }
    return revBuilder.toString();
  }

  public static void main(String[] args) {
    StringReverse stringReverse = new StringReverse();
    System.out.println(stringReverse.inRev("abcde"));
  }

}
