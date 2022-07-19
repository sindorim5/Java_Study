package com.ssafy.ws05.step3;

public class BookManager {
    private int MAX_SIZE = 100;
    private Book[] books;
    private int size = 0;

    public BookManager() {
        books = new Book[MAX_SIZE];
    }

    public void add(Book book) {
        books[size] = book;
        size++;
    }

    public void remove(String isbn) {
        Book b = searchByIsbn(isbn);
        for (int i = 0; i < size; i++) {
            if (books[i].equals(b)) {
                books[i] = books[--size];
                books[size] = null;    
            }
        }
    }

    public Book[] getList() {
        int i = 0;
        Book[] result = new Book[size];
        while(books[i] != null) {
            result[i] = books[i];
            i++;
        }
        return result;
    }

    public Book searchByIsbn(String isbn) {
        for (int i = 0; i < size; i++) {
            if (isbn.equals(books[i].getIsbn())) {
                return books[i];
            }
        }

        return null;
    }

    public Book[] searchByTitle(String title) {
        Book[] searchedBooks = new Book[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(title)) {
                searchedBooks[j] = books[i];
                j++;
            }
        }

        Book[] result = new Book[j];

        for (int i = 0; i < j; i++) {
            if (searchedBooks[i] != null) {
                result[i] = searchedBooks[i];
            }
        }

        return result;
    }

    public Book[] getBooks() {
        Book[] searchedBooks = new Book[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if(books[i] instanceof Book) {
                searchedBooks[j] = books[i];
                j++;
            }
        }
        
        Book[] result = new Book[j];

        for (int i = 0; i < j; i++) {
            if (searchedBooks[i] != null) {
                result[i] = searchedBooks[i];
            }
        }

        return result;
    }

    public Book[] getMagazines() {
        Book[] searchedBooks = new Book[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if(books[i] instanceof Magazine) {
                searchedBooks[j] = books[i];
                j++;
            }
        }
        
        Book[] result = new Book[j];

        for (int i = 0; i < j; i++) {
            if (searchedBooks[i] != null) {
                result[i] = searchedBooks[i];
            }
        }

        return result;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += books[i].getPrice();
        }
        return sum;
    }

    public double getPriceAvg() {
        int sum = getTotalPrice();
        return sum / size;
    }
}
