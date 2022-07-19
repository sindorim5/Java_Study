package com.ssafy.oop4_4.thread.syncwait;

class SyncTest {
    public static void main(String[] args) {
//        MainData m = new MainData0(); // 없는
//         MainData m = new MainData1();// synchronized
         MainData m = new MainData2();// wait, notify

        IncThread t1 = new IncThread(m, "공급자 A");
        IncThread t3 = new IncThread(m, "공급자 B");

        DecThread t2 = new DecThread(m, "구매자 a");
        DecThread t4 = new DecThread(m, "구매자 b");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
