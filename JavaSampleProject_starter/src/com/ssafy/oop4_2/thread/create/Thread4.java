package com.ssafy.oop4_2.thread.create;

public class Thread4 {
    public static void main(String[] args) {
        Thread4 t = new Thread4();
        t.go();
    }

    public void go() {
        // Thread 상속
        class AThread extends Thread {
            public void run() {

            }
        }

        Thread a = new AThread();
        a.start();

        Thread t = new Thread() { // anonymous nested class
            public void run() {
            }
        };
        t.start();

        new Thread() { // anonymous nested class
            public void run() {
            }
        }.start();

        // Runnable implements..
//        class BRunnable implements Runnable{
//            public void run() {}
//        }
//        
//        Runnable r = new BRunnable();

        //////////////
//        Runnable r = new Runnable() {
//        public void run() {}
//        };
//    
//        Thread t3 = new Thread(r);
//        t3.start();

        new Thread(new Runnable() {
            public void run() { 
                
            }
        }).start();
        
        new Thread(() -> { // lambda 

        }).start();
    }

}
