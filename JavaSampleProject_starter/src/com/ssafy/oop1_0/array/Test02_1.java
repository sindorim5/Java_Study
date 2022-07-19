package com.ssafy.oop1_0.array;

public class Test02_1 {
    public static void main(String[] args) {

        String ssafyStr = "SSAFY";

        char[] ssafyArray = new char[ssafyStr.length()];

        for (int i = 0; i < ssafyArray.length; i++) {
            ssafyArray[i] = ssafyStr.charAt(i);
        }

        for (int i = 0; i < ssafyArray.length; i++) {
            System.out.print(ssafyArray[i]);
        }

    }
}