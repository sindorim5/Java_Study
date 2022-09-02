package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.annotations.ApiOperation;

@RequestMapping("/bookapi")
@RestController
@CrossOrigin("*")
public class BookRestController {
    private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private BookService bookService;
    
    @ApiOperation(value = "query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환한다.")
    @GetMapping("/book")
    public ResponseEntity<List<Book>> selectAll() {
        List<Book> bookList = bookService.search();
        if (bookList != null && !bookList.isEmpty()) {
            return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Book>>(bookList, HttpStatus.NO_CONTENT);
        }

    }
    
    @ApiOperation(value = "{isbn}에 해당하는 도서 정보를 반환한다.")
    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> selectBook(@PathVariable String isbn) {
        logger.info(isbn);
        Book bookDto = bookService.select(isbn);
        if (bookDto != null) {
            return new ResponseEntity<Book>(bookDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<Book>(bookDto, HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Book 객체를 저장한다.")
    @PostMapping("/book")
    public ResponseEntity<Integer> insertBook(@RequestBody Book book) {
        int result = bookService.insert(book);
        if (result != 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }

    }

    @ApiOperation(value = "Book 객체를 수정한다.")
    @PutMapping("/book")
    public ResponseEntity<Integer> modifyBook(@RequestBody Book book) {
        int result = bookService.update(book);
        if (result != 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }
    }

    @ApiOperation(value = "Book 객체를 삭제한다.")
    @DeleteMapping("/book/{isbn}")
    public ResponseEntity<Integer> deleteBook(@PathVariable String isbn) {
        int result = bookService.delete(isbn);
        if (result != 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }
    }

}
