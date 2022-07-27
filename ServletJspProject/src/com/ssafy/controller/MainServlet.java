package com.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.move.BookDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<BookDto> list = new ArrayList<BookDto>();
    
    public void init() {
        list.add(new BookDto("a1298", "java 해부하기", "SSAFY출판", 25000));
        list.add(new BookDto("a2276", "BackEnd란", "JAEN출판사", 25000));
        list.add(new BookDto("a7633", "Spring Framework", "삼성출판", 25000));
        list.add(new BookDto("a3030", "공부잘하는방법", "SSAFY출판", 25000));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        execute(request, response);
    }
    
    /**
     * Front Controller 역할을 수행. 
     * 1. action에 따라서 business logic을 호출하고, 
     * 2. 이동할 target을 결정한다.  
     */
    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String isbn = request.getParameter("isbn");
        
        String targetJsp = "";
        
        if("ft".equals(action)) {
            request.setAttribute("bookinfo", getBookByIsbn(isbn));
            targetJsp = "jspview/book.jsp";
        }else if("ft_el".equals(action)) {
            request.setAttribute("bookinfo", getBookByIsbn(isbn));
            targetJsp = "jspview/book_el.jsp";
        }else if("ft_list".equals(action)) {
            request.setAttribute("bookList", list);
            targetJsp = "jspview/booklist.jsp";
        }else if("ft_list_el".equals(action)) {
            request.setAttribute("bookList", list);
            targetJsp = "jspview/booklist_el.jsp";
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(targetJsp);
        dispatcher.forward(request, response);
    }
    
    private BookDto getBookByIsbn(String isbn) {
        BookDto bookDto = null;
        for(BookDto book : list) {
            if(book.getIsbn().equals(isbn)) {
                bookDto = book;
                break;
            }
        }
        return bookDto;
    }
}
