package com.ssafy.ws04.step3;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) throws QuantityException, ISBNNotFoundException {
		IBookManager mgr = BookManagerImpl.getInstance();
		BookTest test = new BookTest();
		ArrayList<Book> list = mgr.getList();

		// add
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10);
		Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20);
		Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30);
		Book b4 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1);
		
		mgr.add(b1);
		mgr.add(b2);
		mgr.add(b3);
		mgr.add(b4);
		
		mgr.saveData();

		System.out.println("********************도서 전체 목록********************");
		test.printBookList(list);
		System.out.println();

//		// searchByIsbn
//		Book searchedIsbn = mgr.searchByIsbn("21424");
//		System.out.println("********************ISBN검색: 21424********************");
//		System.out.println(searchedIsbn);
//		System.out.println();
//
//		// searchByTitle
//		System.out.println("********************도서 제목 포함검색:Java********************");
//		ArrayList<Book> searchedBooks = mgr.searchByTitle("Java");
//		test.printBookList(searchedBooks);
//		System.out.println();
//
//		System.out.println("********************일반 도서 목록********************");
//		ArrayList<Book> normalList = mgr.getBooks();
//		test.printBookList(normalList);
//		System.out.println();
//
//		System.out.println("********************잡지 목록********************");
//		ArrayList<Book> magazineList = mgr.getMagazines();
//		test.printBookList(magazineList);
//		System.out.println();
//
//		System.out.println("도서 가격 총합 : " + mgr.getTotalPrice());
//		System.out.println("도서 가격 평균 : " + mgr.getPriceAvg());
//		System.out.println();
//
//		System.out.println("********************도서판매: 21424, 11개********************");
//		mgr.sell("21424", 11); // QuantityException: 수량이 부족합니다.
//		System.out.println();

//		System.out.println("********************도서구매: 21424, 10개********************");
//		mgr.buy("21424", 10);
//		Book theBook = mgr.searchByIsbn("21424");
//		System.out.println(theBook);
//		System.out.println();
//
//		System.out.println("********************도서판매: 21424, 11개********************");
//		mgr.sell("21424", 11);
//		System.out.println();

	}

	public void printBookList(ArrayList<Book> bList) {
		for (Book b : bList) {
			if (b != null) {
				System.out.println(b);
			}
		}
	}

}
