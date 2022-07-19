package com.ssafy.oop1_0.array;

public class Test01_3 {
    public static void main(String[] args) {

        int N = 6;

        int[] resultArray = new int[5];

        for (int i = 0; i < 5; i++) {
            resultArray[i] = (int) (Math.random() * N) + 1;
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(resultArray[i]);
        }

    }
}