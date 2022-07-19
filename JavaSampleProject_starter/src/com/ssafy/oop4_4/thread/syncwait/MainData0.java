package com.ssafy.oop4_4.thread.syncwait;

class MainData0 extends Object implements MainData {
    int data;

    public void increase(String name) {
        System.out.print(name + "가 " + data);
        pause(500);
        data++;
        System.out.println("를 " + data + "로 증가시킴");
    }

    public void decrease(String name) {
        System.out.print(name + "가 " + data);
        pause(100);
        data--;
        System.out.println("를 " + data + "로 감소시킴");
    }

    public void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}