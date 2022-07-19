package com.ssafy.oop3_6.exception;

import java.io.*;

class InputFile2 {

    public static void main(String[] str) {
        String fileName = "data.txt";
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try {
            in = new BufferedReader(new FileReader(fileName));
            String temp = in.readLine();
            while (temp != null) {
                sb.append(temp + "\n");
                temp = in.readLine();
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e1) {
            System.out.println(fileName + " 파일을 읽는데 실패!!!");
            e1.printStackTrace();
        } catch (IOException e2) {
            System.out.println(fileName + " IOException!!");
            e2.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
