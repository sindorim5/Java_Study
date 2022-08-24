package com.ssafy.ws;

import static org.junit.Assert.*;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.UserRepo;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.BookServiceImpl;
import com.ssafy.ws.model.service.UserService;


public class WS_01_BeanCreationTest extends AbstractTest {
    
    @Autowired
    BookRepo bookRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;
    
    @Autowired
    BasicDataSource ds;

    @Test
    public void test() {
        assertNotNull(bookRepo);
        assertNotNull(userRepo);
        assertNotNull(bookService);
        assertNotNull(userService);
        assertEquals(((BookServiceImpl)bookService).getBookRepo(), bookRepo);
        assertNotNull(ds);
    
    }

}




