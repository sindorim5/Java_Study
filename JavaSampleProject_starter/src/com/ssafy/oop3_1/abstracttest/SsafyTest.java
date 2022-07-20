package com.ssafy.oop3_1.abstracttest;

public class SsafyTest {
	public static void main(String[] arg) {
//		Ssafy s1 = new Ssafy(); SSafy class를 하나만 만들고 싶다.
//		Ssafy s2 = new Ssafy(); new 키워드를 못 쓰게 해야됨.

		Ssafy s1 = Ssafy.getInstance(); // getInstance()로 obj를 가져간다.
	}
}
