package com.java.first;

public class CircleArea {

    public static void main(String[] args) {
        int radius = 5;
        double PI = Math.PI;
        double result = radius * radius * PI;

        System.out.println("반지름이 " + radius + "Cm인 원의 넓이는 " + String.format("%.1f", result) + "Cm2입니다.");
    }
}
