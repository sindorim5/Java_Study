package com.ssafy.oop4_1.io2_processing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        Person person1 = new Person("홍길동", 20, "111111-2222222", "hong", "1234");
        Person person2 = new Person("이순신", 20, "111111-1111111", "Lee", "1234");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        // csv 파일 출력
        String filePath = "sample_folder" + File.separator + "SSAFY";
        String fileName = "CoronaPatientList.csv";

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath + File.separator + fileName), "MS949"));) {
            for (Person p : personList) {
                writer.write(p.name + "," + p.age);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person {

    String name;
    int age;
    transient String ssn;

    public Person(String name, int age, String ssn, String userId, String userPass) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", ssn=" + ssn + "]";
    }
}