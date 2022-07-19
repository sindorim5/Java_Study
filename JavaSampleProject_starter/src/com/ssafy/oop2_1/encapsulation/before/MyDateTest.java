package com.ssafy.oop2_1.encapsulation.before;

class MyDateTest {
    public static void main(String[] args) {
        MyDate today = new MyDate();
        today.year = 2021;
        today.month = 19;
        today.day = 7;
        System.out.println(today.toString());
        System.out.println(today);
    }
}
