package com.ssafy.oop4_1.io2_processing;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputTest {
    public static void main(String arg[]) {
        try {
            FileInputStream fis = new FileInputStream("TestFile.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            int i = dis.readInt();
            double d = dis.readDouble();
            boolean b = dis.readBoolean();
            String s = dis.readUTF();
            System.out.println(d);
            System.out.println(i);
            System.out.println(b);
            System.out.println(s);
            dis.close();
            bis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("ERROR " + e.toString());
        }
    }
}