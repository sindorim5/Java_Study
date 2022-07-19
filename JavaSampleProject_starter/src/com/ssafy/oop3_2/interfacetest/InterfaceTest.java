package com.ssafy.oop3_2.interfacetest;

interface Trans {
    abstract void start(); // 동일 : public abstract void start();

    void stop(); // 동일 : public abstract void stop();

    default public void doTrans() {
        System.out.println("default method");
    }
}

class Bus implements Trans {
    public void start() {
        System.out.println("Bus start...");
    }

    public void stop() {
        System.out.println("Bus Stop...");
    }
}

class InterfaceTest {
    public static void main(String[] a) {
        Trans t = new Bus();
        t.start();
        t.stop();

        t.doTrans();

        Bus b = (Bus) t;
        b.doTrans();
    }
};
