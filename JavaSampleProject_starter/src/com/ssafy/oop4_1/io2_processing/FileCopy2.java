package com.ssafy.oop4_1.io2_processing;

import java.io.*;

class FileCopy2 {
	public static void main(String arg[]) {
		try (// Auto-Close
				BufferedInputStream in = new BufferedInputStream(new FileInputStream("data.txt"));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data3.txt"));) {

			byte[] b = new byte[1024];
			int read = 0;
			while ((read = in.read(b)) != -1) {// 파일의 끝이 아닐 때까지
				out.write(b, 0, read); // b 배열 버퍼에 쓰기. 0부터 read만큼.
				out.flush(); // 버퍼에 쓴 내용 파일에 쓰기.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}