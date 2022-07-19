package com.ssafy.oop4_4.thread.syncwait;

class IncThread extends Thread {
    MainData md;

    public IncThread(MainData md, String n) {
        super(n); // Thread name
        this.md = md;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((int) (Math.random() * 7000));
            } catch (Exception e) {
            }
            md.increase(getName());
        }
    }
}
