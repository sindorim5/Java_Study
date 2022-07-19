package com.ssafy.oop1_0.array;

import java.util.Arrays;

public class Test09 {
    public static void main(String[] args) {

        int[] intArray = { 3, 7, 2, 5, 7, 7, 9, 2, 8, 1, 1, 5, 3 };
        int[] used = new int[10];

        for (int i = 0; i < intArray.length; i++) {
            used[intArray[i]]++;
        }

        System.out.println(Arrays.toString(used));

    }
}