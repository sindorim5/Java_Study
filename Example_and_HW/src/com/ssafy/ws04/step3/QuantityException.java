package com.ssafy.ws04.step3;

class QuantityException extends Exception {
	
	private static final long serialVersionUID = 454859008722508385L;
	
	public QuantityException() {
		System.out.println("QuantityException: 수량이 부족합니다.");
	}

}
