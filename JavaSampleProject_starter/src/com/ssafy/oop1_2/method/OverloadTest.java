package com.ssafy.oop1_2.method;

import com.ssafy.oop1_3.lifecycle.A;

class OverloadTest {
	public String print(Object x, Object y) {
		return x + "와 " + y + "를 출력합니다.Object, Object";
	}

//    public String print(String x, String y) {
//        return x + "와 " + y + "를 출력합니다.String, String";
//    }

	public String print(String x, int y) {
		return x + "와 " + y + "을 출력합니다.String, int";
	}

	public void print(int x, int y) {
		System.out.println(x + "와 " + y + "을 출력합니다.int, int");
	}

	public void print(long x, long y) {
		System.out.println(x + "와 " + y + "을 출력합니다.long, long");
	}

	public static void main(String[] args) {
		A b = new A();
		OverloadTest ot = new OverloadTest();
		System.out.println(ot.print("A", "B"));
		System.out.println(ot.print("A", 10));
		ot.print(2, 3);
		ot.print(2, 3L);
	}
}