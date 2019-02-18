package com.codility.java;

public class BinaryGap {

    public int solution(int N) {
        String bin = Integer.toString(N, 2);

        int firstIndex = bin.indexOf("1");
        int nextIndex = bin.indexOf("1", firstIndex + 1);
        int strlength = 0;
        while (nextIndex != -1) {
            String stuffBetweenOnes = bin.substring(firstIndex + 1, nextIndex);
            if (strlength < stuffBetweenOnes.length()) {
                strlength = stuffBetweenOnes.length();
            }
            bin = bin.substring(nextIndex);

            firstIndex = bin.indexOf("1");
            nextIndex = bin.indexOf("1", firstIndex + 1);
        }

        return strlength;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.solution(1041)); //
    }
}
