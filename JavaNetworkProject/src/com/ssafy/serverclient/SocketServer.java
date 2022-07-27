package com.ssafy.serverclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        //생성자에 port번호를 입력하여, ServerSocket을 엽니다. 
        try (ServerSocket server = new ServerSocket(10001)){
            System.out.println("Server start...");
        
            while (true) {
                Socket s = server.accept(); // accept에서 client접속을 대기합니다. 
                //accept()는 client 가 접속하면 해당 client와 연결된 socket을 리턴합니다. 
        
                //연결된 socket으로 부터 input/output을 뽑아냅니다. 
                // 이후는 java io programming과 동일하게 처리합니다.  
                try (BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);) {
        
                    //순서 맞춰야 합니다. 
                    //서버 code는 readLine을 먼저 하고 난 후에 out으로 전송하고 있으므로, 
                    //client에서는 먼저 전송하고 그 이후에 데이터를 read 해야 합니다.  
                    String clientMessge = in.readLine();
                    System.out.println("CLIENT MESSAGE : " + clientMessge);
        
                    
                    // http 규약에 맞게 응답하지 않음
                    out.println("Hello this is Server");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
