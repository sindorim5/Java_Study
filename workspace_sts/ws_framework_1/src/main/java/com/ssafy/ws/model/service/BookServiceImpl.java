package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.Book;
import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.BookRepoImpl;

public class BookServiceImpl implements BookService {

//    private BookServiceImpl() {};
    
    private BookRepo bookRepo;
    
    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    
    public BookRepo getBookRepo() {
        return bookRepo;
    }
    
    @Override
    public int insert(Book book) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Book book) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(String isbn) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Book select(String isbn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> search() {
        // TODO Auto-generated method stub
        return null;
    }



    
    
    
}
