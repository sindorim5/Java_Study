package com.ssafy.ws04.step3;

import java.util.ArrayList;

public interface IBookManager {
		
	abstract void loadData();
	
	abstract void saveData();
	
	abstract void add(Book book);

	abstract void remove(String isbn) throws ISBNNotFoundException;

	abstract ArrayList<Book> getList();

	abstract Book searchByIsbn(String isbn) throws ISBNNotFoundException;

	abstract ArrayList<Book> getMagazines();

	abstract ArrayList<Book> getBooks();

	abstract int getTotalPrice();

	abstract void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	abstract void buy(String isbn, int quantity) throws ISBNNotFoundException;



}
