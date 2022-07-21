package com.ssafy.ws07.step3;

import java.util.ArrayList;

public class BookManagerImpl implements IBookManager {
	private ArrayList<Book> books;

	public BookManagerImpl() {
		books = new ArrayList<>();
	}

	public void add(Book book) {
		books.add(book);
	}

	public void remove(String isbn) throws ISBNNotFoundException {
		Book b = searchByIsbn(isbn);
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).equals(b)) {
				books.remove(i);
			}
		}
	}

	public ArrayList<Book> getList() {
		return books;
	}

	public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
		for (int i = 0; i < books.size(); i++) {
			if (isbn.equals(books.get(i).getIsbn())) {
				return books.get(i);
			}
		}
		throw new ISBNNotFoundException(isbn);
	}

	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> searchedBooks = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().contains(title)) {
				searchedBooks.add(books.get(i));
			}
		}
		return searchedBooks;
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> searchedBooks = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (!(books.get(i) instanceof Magazine)) {
				searchedBooks.add(books.get(i));
			}
		}
		return searchedBooks;
	}

	public ArrayList<Book> getMagazines() {
		ArrayList<Book> searchedBooks = new ArrayList<Book>();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) instanceof Magazine) {
				searchedBooks.add(books.get(i));
			}
		}
		return searchedBooks;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < books.size(); i++) {
			sum += books.get(i).getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		int sum = getTotalPrice();
		return sum / books.size();
	}

	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book bookToSell;
		bookToSell = searchByIsbn(isbn);
		int q = bookToSell.getQuantity();
		if (quantity > q) {
			throw new QuantityException(); // runtime exception
		} else {
			bookToSell.setQuantity(q - quantity);
			System.out.println(bookToSell);
		}
	}

	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book bookToBuy;
		bookToBuy = searchByIsbn(isbn);
		int q = bookToBuy.getQuantity();
		bookToBuy.setQuantity(q + quantity);
	}
}
