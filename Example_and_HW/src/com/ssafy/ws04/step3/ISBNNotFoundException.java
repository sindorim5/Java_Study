package com.ssafy.ws04.step3;

class ISBNNotFoundException extends Exception {

	private static final long serialVersionUID = 817537219930564654L;

	public ISBNNotFoundException(String isbn) {
		System.out.println("ISBNNotFoundException: " + isbn + "도서를 찾을 수 없습니다.");
	}
	
	public String getIsbn(String isbn) {
		return isbn;
	}
	
}
