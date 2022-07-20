package com.ssafy.hw03.step3;

class QuantityException extends Exception {
	
	private static final long serialVersionUID = 2L;
	
	public QuantityException() {
		System.out.println("QuantityException: 수량이 부족합니다.");
	}

}