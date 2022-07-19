package com.ssafy.oop3_1.abstracttest;

abstract class Trans {
    abstract void start();

    abstract void stop();

    public void playMusic() {
        System.out.println("음악이 나옵니다.");
    }
}

class Bus extends Trans {
    public void start() {
        System.out.println("Bus start...");
    }

    public void stop() {
        System.out.println("Bus Stop...");
    }
}

class AbstractTest {
    public static void main(String[] a) {
        Trans t = new Bus();
        t.start();
        t.playMusic();
        t.stop();
    }
}


