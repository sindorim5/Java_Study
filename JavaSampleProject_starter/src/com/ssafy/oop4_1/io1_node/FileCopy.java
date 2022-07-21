package com.ssafy.oop4_1.io1_node;

import java.io.*;

class FileCopy {
	public static void main(String arg[]) {
		try {
			FileInputStream in = new FileInputStream("data.txt");
			FileOutputStream out = new FileOutputStream("data2.txt");

			int read = 0;
			while ((read = in.read()) != -1) {// 파일의 끝이 아닐 때까지
				out.write(read);
				System.out.print((char) read);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}