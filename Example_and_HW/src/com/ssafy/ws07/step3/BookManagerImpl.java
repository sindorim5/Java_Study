package com.ssafy.ws07.step3;

import java.util.ArrayList;

public class BookManagerImpl implements IBookManager {
	private int MAX_SIZE = 100;
	private ArrayList<Book> books;
	private int size = 0;

	public BookManagerImpl() {
		books = new ArrayList<>(MAX_SIZE);
	}

	public void add(Book book) {
		books.add(book);
		size++;
	}

	public void remove(String isbn) {
		Book b = searchByIsbn(isbn);
		for (int i = 0; i < size; i++) {
			if (books.get(i).equals(b)) {
				books.remove(i);
			}
		}
	}

	public ArrayList<Book> getList() {
		return books;
	}

	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (isbn.equals(books.get(i).getIsbn())) {
				return books.get(i);
			}
		}
		return new ;	// new exception
	}

	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> searchedBooks = new ArrayList<Book>(size);
		for (int i = 0; i < size; i++) {
			if (books.get(i).getTitle().contains(title)) {
				searchedBooks.add(books.get(i));
			}
		}
		return searchedBooks;
	}

	public ArrayList<Book> getBooks() {
		ArrayList<Book> searchedBooks = new ArrayList<Book>(size);
		for (int i = 0; i < size; i++) {
			if (books.get(i) instanceof Book) {
				searchedBooks.add(books.get(i));
			}
		}
		return searchedBooks;
	}

	public ArrayList<Book> getMagazines() {
		ArrayList<Book> searchedBooks = new ArrayList<Book>(size);
		for (int i = 0; i < size; i++) {
			if (books.get(i) instanceof Magazine) {
				searchedBooks.add(books.get(i));
			}
		}
		return searchedBooks;
	}

	public int getTotalPrice() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += books.get(i).getPrice();
		}
		return sum;
	}

	public double getPriceAvg() {
		int sum = getTotalPrice();
		return sum / size;
	}

	public void sell(String isbn, int quantity) throws QuantityException {
		Book bookToSell;
		try {
			bookToSell = searchByIsbn(isbn);
			if (bookToSell != null) {
				int q = bookToSell.getQuantity();
				if (quantity > q) {
					throw new QuantityException();	// runtime exception
				} else {
					bookToSell.setQuantity(q - quantity);
					System.out.println(bookToSell);
				}
			}
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void buy(String isbn, int quantity) {
		Book bookToBuy;
		try {
			bookToBuy = searchByIsbn(isbn);
			if (bookToBuy != null) {
				int q = bookToBuy.getQuantity();
				bookToBuy.setQuantity(q + quantity);
			}
		} catch (ISBNNotFoundException e) {
			
			e.printStackTrace();
		}

	}
}
