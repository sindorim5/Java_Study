package com.ssafy.oop4_1.io3_object;

import java.io.Serializable;

public class PersonObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String ssn;
    
    public PersonObject(String name, int age, String ssn, String userId, String userPass) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
    }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", ssn=" + ssn    + "]";
    }
}