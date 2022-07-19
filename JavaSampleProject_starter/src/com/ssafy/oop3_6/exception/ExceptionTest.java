package com.ssafy.oop3_6.exception;

public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
        et.exceptionTest();
        System.out.println("main End..");
    }

    public void exceptionTest() {
        int i = 0;
        String greetings[] = { "Good Bye", "Hi~", "안녕히~" };
        try {
            while (i < 4) {
                System.out.println(greetings[i]);
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
        System.out.println("Method End.." + i);
    }
}
