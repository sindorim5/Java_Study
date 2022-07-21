package com.ssafy.oop4_2.thread.create;

public class Thread3 {
	public static void main(String args[]) {
//        Runnable r1 = new MyThread3();
//        Runnable r2 = new MyThread3();
//        Runnable r3 = new MyThread3();
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2, "Two");
//        Thread t3 = new Thread(r3, "Three");

		Runnable r = new MyThread3();
		Thread t1 = new Thread(r, "One");
		Thread t2 = new Thread(r, "Two");
		Thread t3 = new Thread(r, "Three");

		t1.start();
		t2.start();
		t3.start();
	}
}

class MyThread3 implements Runnable {
	private int cnt;

	public void run() {
		while (true) {
//            try {
//                Thread.sleep(100);
//                // CPU 점유중인 Thread를 Block State로 보냄.(100msec동안)
//            } catch (InterruptedException e) {
//                System.out.println(e.toString());
//            }
            synchronized(this) {
			// 값만 갖고 왔다가 출력을 못하고 끝나는 경우도 있다.
            // synchronized를 사용하면 one이 lock flag를 가져가서
            // two three는 lock pool에서 완료를 기다린다.
			System.out.println(Thread.currentThread().getName() + " : " + ++cnt);
			if (cnt >= 10)
				break;
            }
		}
	}
}
