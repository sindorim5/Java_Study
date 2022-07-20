package com.ssafy.oop3_2.interfacetest;

interface Trans {
	abstract void start(); // 동일 : public abstract void start();

	void stop(); // 동일 : public abstract void stop();

	default public void doTrans() { // 있어야 됨
		System.out.println("default method");
	}
}

interface Vehicle { // 같은 메소드가 있어 오류발생
	default public void doTrans() {
		System.out.println("default method");
	}
}

class Bus implements Trans, Vehicle {
	public void start() {
		System.out.println("Bus start...");
	}

	public void stop() {
		System.out.println("Bus Stop...");
	}

	@Override
	public void doTrans() { // IDE가 override 하라고 추천
		// TODO Auto-generated method stub
		Trans.super.doTrans();
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
