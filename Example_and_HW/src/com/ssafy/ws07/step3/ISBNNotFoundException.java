package com.ssafy.ws07.step3;

class ISBNNotFoundException extends Exception {

	private static final long serialVersionUID = 2817537219930564654L;

	public ISBNNotFoundException() {
		super("ISBNNotFoundException: 해당 도서가 없습니다.");
	}
	
	public String getIsbn() {
		return "";
	}
	
}
