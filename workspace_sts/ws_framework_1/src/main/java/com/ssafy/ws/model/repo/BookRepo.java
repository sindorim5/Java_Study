package com.ssafy.ws.model.repo;

import java.util.List;

import com.ssafy.ws.model.Book;

public interface BookRepo {
    public int insert(Book book);
    public int update(Book book);
    public int delete(String isbn);
    public Book select(String isbn);
    public List<Book> search();
}
