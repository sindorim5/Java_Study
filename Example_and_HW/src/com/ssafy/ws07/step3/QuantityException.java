package com.ssafy.ws07.step3;

class QuantityException extends RuntimeException {
	
	private static final long serialVersionUID = 5454859008722508385L;
	
	public QuantityException() {
		System.out.println("QuantityException: 수량이 부족합니다.");
	}

}
