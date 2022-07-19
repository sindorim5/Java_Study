package com.ssafy.oop1_1.constructor;

class MyDateTest {
    public static void main(String[] args) {
        MyDate today = new MyDate();	// 생성자를 호출한다.
        today.year = 2021;
        today.month = 10;
        today.day = 10;

        MyDate today2 = new MyDate(2021, 10, 10);

        MyDate birth = new MyDate(2022, 9, 7);
        System.out.println(birth.toString());
//        System.out.println(birth); // birth.toString()
//
//        MyDate birth2 = new MyDate(8, 7);
//        System.out.println(birth2); // birth2.toString()

    }
}
