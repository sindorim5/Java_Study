package com.ssafy.oop4_1.io3_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputTest {
    
    public static void main(String[] args) {
        File target = new File("sample_folder" + File.separator + "SSAFY" + File.separator + "objPerson.dat");
//        PersonObject person = new PersonObject("홍길동", 20, "111111-2222222", "hong", "1234");
        try {
    
//            // 객체 로딩
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));
            Object readed = ois.readObject();
            if (readed != null && readed instanceof PersonObject) {
                PersonObject casted = (PersonObject) readed;
                System.out.println(casted);
            }
            ois.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

