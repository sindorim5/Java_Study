package com.ssafy.oop3_6.exception;

public class ExceptionTest1 {
    public static void main(String[] args) {
        ExceptionTest1 et = new ExceptionTest1();
        et.exceptionTest();
        System.out.println("main End..");
    }

    public void exceptionTest() {
        int i = 0;
        String greetings[] = { "Good Bye", "Hi~", "안녕히~" };
        while (i < 4) {
            try {
                String str = greetings[i];
                System.out.println(str);
                if (i == 1)
                    break;
            } catch (ArrayIndexOutOfBoundsException ae) {
                System.out.println("범위를 넘었습니다.");
            } finally {
                System.out.println("항상 수행~");
            }
            i++;
        }
        System.out.println("Method End.." + i);
    }
}
