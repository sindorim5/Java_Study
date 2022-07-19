package com.ssafy.oop1_4.modifier;

class Var {
	final double PI = 3.141592; // 상수. primitive 상수명은 모두 대문자
	int number = 10;
}

class FinalVarTest {
	public static void main(String s[]) {
		Var f1 = new Var();
		// f1.PI=20; //final 변수여서 값변경 안됨
		f1.number = 20;

		System.out.println(Constants.COUNT);
		System.out.println(Constants.END);
		double d = Math.PI;
		System.out.println(d);

	}
}

class Constants {
	public static final double PI = 3.141592;
	public static final int COUNT = 50;
	public static final int START = 10;
	public static final int END = 100;
}
