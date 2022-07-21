package com.ssafy.oop4_2.thread.create;

public class Thread1 {
	public static void main(String args[]) {
		System.out.println("main()...1...");
		MyThread a = new MyThread();
		a.start();// -> start()로 Thread를 실행함. run()호출이 아님!!.

		System.out.println("main()...2...");
//		try {
//			Thread.sleep(30);
//		} catch (InterruptedException ie) {
//		}
		System.out.println("main()...3...");
	}
}

class MyThread extends Thread {
	int i;

	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " : " + i++);
//            try {
//            Thread.sleep(100);
//            // CPU 점유중인 Thread를 Block State로 보냄.(100msec동안)
//        } catch (InterruptedException e) {
//            System.out.println(e.toString());
//        }
			if (i >= 10)
				break;
		}
	}
}
