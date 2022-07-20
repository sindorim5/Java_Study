package com.ssafy.oop1_3.lifecycle;

class MethodTest {
	void method(int i, int j) {
		int temp = 0;
		temp = i;
		i = j;
		j = temp;
		System.out.println("method => i=" + i + ", j=" + j);
	}

	public static void main(String[] args) {
		A a = new A();
		int i = 10, j = 20;
		System.out.println("main => i=" + i + ", j=" + j);
		MethodTest m = new MethodTest();
		m.method(i, j);
		System.out.println("main => i=" + i + ", j=" + j);

		int test, test1;

		// 논리상 문제는 없지만 값이 할당되는 것은 compile이 아닌 runtime 때이므로, compile 단계에서 오류가 난다.
		if (i < 100) {
			test = 100;
		}

		// 가능
		if (true) {
			test1 = 100;
		}

//		System.out.println(test);
		System.out.println(test1);

	}
}