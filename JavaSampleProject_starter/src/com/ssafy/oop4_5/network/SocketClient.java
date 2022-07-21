package com.ssafy.oop4_5.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		// 접속할 서버의 ip와 port로 socket을 생성한다.
		try (Socket s = new Socket("127.0.0.1", 10001)) { // localhost

			// 연결된 socket으로 부터 input/output을 뽑아냅니다.
			// 이후는 java io programming과 동일하게 처리합니다.
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);

			// 순서 맞춰야 합니다.
			// 서버 code는 readLine을 먼저 하고, out으로 전송하고 있으므로,
			// client에서는 먼저 전송하고 그 이후에 데이터를 read 해야 합니다.
			out.println("Hello this is client.");

			String serverMessage = in.readLine();

			System.out.println("SERVER MESSAGE : " + serverMessage);

			in.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
