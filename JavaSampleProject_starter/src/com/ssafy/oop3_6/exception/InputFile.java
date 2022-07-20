package com.ssafy.oop3_6.exception;

import java.io.*;

class InputFile {

    public static void main(String[] a) {
        String fileName = "data.txt";
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        in = new BufferedReader(new FileReader(fileName));
        String temp = in.readLine();
        while (temp != null) {
            sb.append(temp + "\n");
            temp = in.readLine();
        }
        System.out.println(sb.toString());

        System.out.println("프로그램을 종료합니다.");
    }
}
