package com.ssafy.oop4_1.io2_processing;

import java.io.*;

class FileCopy2WithStatus {
    public static void main(String arg[]) {
        try {
            if (arg.length != 2) {
                System.out.println("Usage: java FileCopy " + "sourceFile destFile");
                System.exit(1);
            }
            File f = new File(arg[0]);
            long size = f.length();
            System.out.println(size);
            int write = 0;

            byte[] b = new byte[1024];
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(arg[0])); // 읽을 파일
            BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(arg[1])); // 쓸 파일

            int read;

            while ((read = fis.read(b)) != -1) { // 파일내용의 끝을 리턴시키는 숫자. eof임
                fos.write(b, 0, read); // 이진코드로 읽고, 쓰는 메소드
                write += read;
//                          System.out.print("\r read:"+write+". % : "+(((double)write/size)*100)+" %"); //command line에서 실행해야 정상출력 됨.
                System.out.print(
                        "\r read:" + write + ". % : " + Math.round(((double) write / size) * 100 * 10) / 10.0 + " %");
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("ERROR " + e.toString());
        }
    }
}