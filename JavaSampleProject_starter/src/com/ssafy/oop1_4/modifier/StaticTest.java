package com.ssafy.oop1_4.modifier;

class StaticTest {
	static int count;

	static void setCount(int k) {
		count = k;
		System.out.println("setCount() : " + count);
	}

	static { // static block
		System.out.println("static initialize! count: " + count);
	}

	{ // instance block
		System.out.println("instance initialize..." + (++count));
	}

	public static void main(String args[]) {
		System.out.println("Main Start!");
		StaticTest.setCount(10);

		StaticTest si = new StaticTest();

		System.out.println("Main...");

		StaticTest si2 = new StaticTest();
	}
}
