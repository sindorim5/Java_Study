package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.ws.model.Book;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

//    private BookServiceImpl() {};
    
    public void setBookRepo(BookRepo bookrepo) {
        
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
