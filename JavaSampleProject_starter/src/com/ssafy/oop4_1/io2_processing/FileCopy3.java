package com.ssafy.oop4_1.io2_processing;

import java.io.*;

class FileCopy3 {
	public static void main(String arg[]) {
		try (// Auto-Close
				// 한 줄 씩 읽기
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data.txt")));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data4.txt")));) {

			String read = "";
			while ((read = in.readLine()) != null) { // 파일의 끝이 아닐 때까지, String이니까 null
				out.println(read);
				System.out.println(read);
				out.flush(); // 버퍼에 쓴 내용 파일에 쓰기.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}