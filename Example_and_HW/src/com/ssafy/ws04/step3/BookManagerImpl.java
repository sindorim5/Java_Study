package com.ssafy.ws04.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.ssafy.hw04.step3.Product;

public class BookManagerImpl implements IBookManager {
	private ArrayList<Book> books;

	private static IBookManager instance;

	public static synchronized IBookManager getInstance() {
		if (instance == null) {
			instance = new BookManagerImpl();
		}
		return instance;
	}

	private BookManagerImpl() {
		System.out.println("********************불러온 도서 전체 목록********************");
		loadData();
	}

	public void loadData() {
		File loadTarget = new File("book.dat");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadTarget));
			Object readed = null;
			readed = ois.readObject();
			// readed를 불러온 경우
			if (readed != null && readed instanceof ArrayList) {
				books = (ArrayList<Book>) readed;
				// book.dat은 있는데 등록된 도서가 없는 경우
				if (books.size() == 0) {
					System.out.println("등록된 도서가 없습니다.");
				} else { // book.dat은 있고 등록된 도서도 있는 경우
					for (Book b : books) {
						if (b != null) {
							System.out.println(b);
						}
					}
				}
			} else { // readed가 null, 불러오지 못한 경우엔 초기화
				books = new ArrayList<Book>();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// book.dat이 존재하지 않는 경우
			System.out.println("등록된 도서가 없습니다.");
			saveData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveData() {
		File saveTarget = new File("book.dat");
		// books가 null 이면 초기화
		if (books == null) {
			books = new ArrayList<Book>();
		}
		ArrayList<Book> saveBookList = books;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveTarget));
			oos.writeObject(saveBookList);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(Book book) {
		// 처음보는 책일 때만 저장, searchByIsbn을 하면 에러가 나와서 새로 작성
		Book tempB = new Book();
		for (int i = 0; i < books.size(); i++) {
			if (book.getIsbn().equals(books.get(i).getIsbn())) {
				tempB = books.get(i);
				break;
			}
		}
				
		if (tempB.getIsbn() == null) {
			books.add(book);
		}
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
