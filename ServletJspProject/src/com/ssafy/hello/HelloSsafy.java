package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ssafy")
public class HelloSsafy extends HttpServlet {
    private static final long serialVersionUID = 6975150307078143171L;
    
    @Override
    // 요청을 받았을 때 출력
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
        System.out.println("##################### init");
    }

    @Override
    // 정상 종료시에만 출력
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
        System.out.println("##################### destroy");
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = "ssafy인 여러분";
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // http://127.0.0.1:8080/SJP/ssafy?name=test&address=구미
        String value = request.getParameter("name");
        System.out.println(value);

        String address = request.getParameter("address");
        System.out.println(address);

        out.println("<html>");
        out.println("<head>");
        out.println("    <title>SSAFY에 오신걸 환영합니다.</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello SSAFY!!!<br>");
        out.println("안녕 싸피!!!<br>");
        out.println("안녕 " + value + "!!!");
        out.println("</body>");
        out.println("</html>");
    }

}
