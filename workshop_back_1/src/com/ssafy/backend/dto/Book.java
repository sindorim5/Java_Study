package com.ssafy.backend.dto;

public class Book {
    public String isbn;
    public String title;
    public String author;
    public int price;
    public String desc;

    public Book() {

    }

    public Book(String isbn, String title, String author, int price, String desc) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", desc=" + desc
                + "]";
    }

}
