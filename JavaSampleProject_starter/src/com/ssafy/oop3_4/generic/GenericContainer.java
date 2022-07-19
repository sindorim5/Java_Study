package com.ssafy.oop3_4.generic;

public class GenericContainer<T> {
    private T obj;

    public GenericContainer(){}

    public T getObj() { return obj; }

    public void setObj(T t) { obj = t; }
    
}
