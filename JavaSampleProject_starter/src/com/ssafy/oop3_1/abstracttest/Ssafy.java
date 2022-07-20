package com.ssafy.oop3_1.abstracttest;

public class Ssafy { // 싸피..현실세계에 존재하는 단 하나의 객체.

	private static Ssafy ssafy; // static 영역에 선언

	public static Ssafy getInstance() {
		if (ssafy == null) {
			ssafy = new Ssafy();
		}
		return ssafy;
	}

	private Ssafy() { // 생성자를 private로 막아버림
		super();
	}
}

/* static block에서 선언하는 방법도 있다. */
