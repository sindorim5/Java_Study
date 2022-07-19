package com.ssafy.oop4_4.thread.syncwait;

import java.util.*;

class MainData2 implements MainData {
    List<String> store = new ArrayList<>();

    public synchronized void increase(String name) {
        System.out.print(name + "가 ");
        int n = (int) (Math.random() * 100);
        store.add("Shoes" + n);
        notify();
        System.out.println("Shoes" + n + " 입고");
    }

    public synchronized void decrease(String name) {

        if (store.size() == 0) {
            try {
                System.out.println(name + " 대기중...");
                wait();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        String sh = (String) store.get(store.size() - 1);
        store.remove(store.size() - 1);
        System.out.println(name + "가 " + sh + " 구매");
    }
}