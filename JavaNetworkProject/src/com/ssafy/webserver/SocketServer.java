package com.ssafy.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Browser호출에 반응하는 Web Sevrver 만들기
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10001);
            System.out.println("Server start...");

            while (true) {
                Socket client = server.accept();

                try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);) {

                    // print client request information
                    String str = "";
                    while (!(str = in.readLine()).equals("")) {
                        System.out.println(str);
                    }

                    // http 규약에 맞게 응답
                    out.println("HTTP/1.0 200 OK");
                    out.println("Server: MyServer 1.0");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");	// 한 줄 띄고 나서 내용 작성
                    out.println("<h1>Hi....</h1><br>");
                    out.println("안녕...");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
