package com.ssafy.oop4_3.thread.control;

class JoinTest {
    public static void main(String[] args) {
        System.out.println("Main Thread Start");
        ThreadA a = new ThreadA();
        a.start();

        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main Thread End");
    }
}

class ThreadA extends Thread {
    public void run() {
        System.out.println("ThreadA Start....");
        for (int i = 0; i <= 5; i++) {
            System.out.println("쓰레드 A 실행 중 " + " " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

