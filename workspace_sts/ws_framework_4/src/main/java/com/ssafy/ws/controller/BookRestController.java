package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.model.service.BookService;

@RequestMapping("/bookapi")
@RestController
@CrossOrigin("*")
public class BookRestController {
    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> selectAll() {
        List<Book> bookList = bookService.search();
        return bookList;
    }

    @GetMapping("/book/{isbn}")
    public Book selectBook(@PathVariable String isbn) {
        logger.info(isbn);
        Book dto = bookService.select(isbn);
        logger.info("book: {}", dto);
        return dto;
    }

    @PostMapping("/book")
    public int insertBook(@RequestBody Book book) {
        logger.info("book: {}", book);
        int temp = bookService.insert(book);
        return temp;
    }

    @PutMapping("/book")
    public int modifyBook(@RequestBody Book book) {
        logger.info("book: {}", book);
        int temp = bookService.update(book);
        return temp;
    }

    @DeleteMapping("/book/{isbn}")
    public int deleteUser(@PathVariable String isbn) {
        int temp = bookService.delete(isbn);
        return temp;
    }

}
