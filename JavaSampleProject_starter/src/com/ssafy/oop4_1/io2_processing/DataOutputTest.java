package com.ssafy.oop4_1.io2_processing;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputTest {
    public static void main(String arg[]) {
        try {
            FileOutputStream fos = new FileOutputStream("TestFile.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            dos.writeInt(4);
            dos.writeDouble(3.0);
            dos.writeBoolean(true);
            dos.writeUTF("this is");
            dos.close();
            bos.close();
            fos.close();
            System.out.println("정상적으로 저장되었습니다");
        } catch (IOException e) {
            System.out.println("ERROR " + e.toString());
        }
    }
}