package com.ssafy.oop4_1.io1_node;

import java.io.*;

class FileCopyWithStatus {
    public static void main(String arg[]) {
        try {
            if (arg.length != 2) {
                //>java com.ssafy.oop4_1.io_node.FileCopyWithStatus c:\windows\explorer.exe ../explorer.exe
                System.out.println("Usage: java FileCopy " + "sourceFile destFile");
                System.exit(1);
            }
            File f = new File(arg[0]);
            long size = f.length();
            System.out.println(size);
            int write = 0;

            FileInputStream fis = new FileInputStream(arg[0]); // 읽을 파일
            FileOutputStream fos = new FileOutputStream(arg[1]); // 쓸 파일
            int ch;
            while ((ch = fis.read()) != -1) {// 파일내용의 끝을을 리턴시키는 숫자. eof임
                fos.write((byte) ch); // 이진코드로 읽고, 쓰는 메소드
                write++;
//                System.out.print("\r read:"+write+". % : "+((write/size)*100)+"%"); //command line에서 실행해야 정상출력 됨.
                System.out.print(
                        "\r read:" + write + ". % : " + Math.round(((double) write / size) * 100 * 10) / 10.0 + " %");

            }

            fis.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.toString());
        }
    }
}