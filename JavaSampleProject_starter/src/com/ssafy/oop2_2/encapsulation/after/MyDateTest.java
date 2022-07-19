package com.ssafy.oop2_2.encapsulation.after;

class MyDateTest {
    public static void main(String[] args) {
        MyDate today = new MyDate();
        today.setYear(2002);
        today.setMonth(2);
        today.setDay(7);
        System.out.println(today.toString());

//        MyDate birth = new MyDate(2004, 9, 7);
//        System.out.println(birth); // birth.toString()
//
//        MyDate birth2 = new MyDate(8, 7);
//        System.out.println(birth2); // birth2.toString()

    }
}
