package com.ssafy.ws.model.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.Book;

@Repository
public class BookRepoImpl implements BookRepo {
    
//    private BookRepoImpl() {}

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
