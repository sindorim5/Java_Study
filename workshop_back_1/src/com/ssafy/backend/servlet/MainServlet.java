package com.ssafy.backend.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.backend.dto.Book;

@WebServlet("/regist.html")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1136659365241564996L;
    private List<Book> list = new ArrayList<Book>();
    
    public void init() {
        list.add(new Book("a1298", "java 해부하기", "강호동", 25000, "JAVA 해부책"));
        list.add(new Book("a2276", "BackEnd란", "유재석", 25000, "BackEnd를 알려드림"));
        list.add(new Book("a7633", "Spring Framework", "이말년", 25000, "스프링"));
        list.add(new Book("a3030", "공부잘하는방법", "주호민", 25000, "공부란 무엇인가"));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    	String action = request.getParameter("action");
    	String isbn = request.getParameter("isbn");
    	String title = request.getParameter("title");
    	String author = request.getParameter("author");
    	int price = Integer.parseInt(request.getParameter("price"));
    	String desc = request.getParameter("desc");
    	list.add(new Book(isbn, title, author, price, desc));
        response.setContentType("text/html;charset=utf-8");
        execute(request, response);
    }
    
    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset = UTF-8");
    	String action = request.getParameter("action");
    	String isbn = request.getParameter("isbn");

        
        String targetJsp = "";
        
        if("regist".equals(action)) {
            request.setAttribute("bookinfo", getBookByIsbn(isbn));
            targetJsp = "jspview/regist_jsp";
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(targetJsp);
        dispatcher.forward(request, response);
    }
    
    private Book getBookByIsbn(String isbn) {
        Book bookDto = null;
        for(Book book : list) {
            if(book.getIsbn().equals(isbn)) {
                bookDto = book;
                break;
            }
        }
        return bookDto;
    }

}
