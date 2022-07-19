package com.ssafy.ws05.step3;

public class BookTest {

    public static void main(String[] args) {
        BookManager mgr = new BookManager();

        // add
        Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 기본 응용");
        Book b3 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
        Book b4 = new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);

        mgr.add(b1);
        mgr.add(b2);
        mgr.add(b3);
        mgr.add(b4);
        
        System.out.println("********************도서 전체 목록********************");
//        System.out.println(b1);
        Book[] list = mgr.getList();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        
        System.out.println();

        // searchByIsbn
        Book searchedIsbn = mgr.searchByIsbn("21424");
        System.out.println("********************ISBN검색: 21424********************");
        System.out.println(searchedIsbn);

        System.out.println();

        // searchByTitle
        System.out.println("********************도서 제목 포함검색:Java********************");
        Book[] searchedBooks = mgr.searchByTitle("Java");
        for (int i = 0; i < searchedBooks.length; i++) {
            System.out.println(searchedBooks[i]);
        }

    }

}
