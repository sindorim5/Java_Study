package com.ssafy.move;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ft_list")
public class ForwardListTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<BookDto> list = new ArrayList<BookDto>();
    
    public void init() {
        list.add(new BookDto("a1298", "java 해부하기", "SSAFY출판", 25000));
        list.add(new BookDto("a2276", "BackEnd란", "JAEN출판사", 25000));
        list.add(new BookDto("a7633", "Spring Framework", "삼성출판", 25000));
        list.add(new BookDto("a3030", "공부잘하는방법", "SSAFY출판", 25000));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("bookList", list);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("jspview/booklist.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("jspview/booklist_el.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
