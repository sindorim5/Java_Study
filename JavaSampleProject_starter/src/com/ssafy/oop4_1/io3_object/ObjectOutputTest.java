package com.ssafy.oop4_1.io3_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputTest {
    
    public static void main(String[] args) {
        File target = new File("sample_folder" + File.separator + "SSAFY" + File.separator + "objPerson.dat");
        PersonObject person = new PersonObject("홍길동", 20, "111111-2222222", "hong", "1234");
        try {
            //객체 저장
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(target));
            oos.writeObject(person);
            oos.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

