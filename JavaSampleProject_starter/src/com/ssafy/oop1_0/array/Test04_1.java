package com.ssafy.oop1_0.array;

public class Test04_1 {
    public static void main(String[] args) {

        int N = 6;

        int[] resultArray = new int[5];

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (int) (Math.random() * N) + 1;
        }

        for (int x : resultArray) {
            System.out.println(x);
        }

    }
}