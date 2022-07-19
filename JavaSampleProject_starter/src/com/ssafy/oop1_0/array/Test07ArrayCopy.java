package com.ssafy.oop1_0.array;

import java.util.Arrays;

public class Test07ArrayCopy {
    public static void main(String[] args) {

        int[] srcArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] tgtArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        System.arraycopy(srcArray, 2, tgtArray, 1, 3);
        
        System.out.println(Arrays.toString(tgtArray));
        
    }
}