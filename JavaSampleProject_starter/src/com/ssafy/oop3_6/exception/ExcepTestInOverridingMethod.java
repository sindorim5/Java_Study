package com.ssafy.oop3_6.exception;

import java.io.IOException;

public class ExcepTestInOverridingMethod {
    public static void main(String[] args) {
        ExcepTestInOverridingMethod et = new ExcepTestInOverridingMethod();
    }
}

class Super{
    public void doSomething() throws NullPointerException {
    }
}

/** 상속관계인 경우 overriding된 method는 
 * 부모 class정의된 Exception이외의 
 * 다른 종류의 Exception을 throws 할 수 없다.*/
class Sub extends Super{
    
    @Override
//    public void doSomething() throws NumberFormatException {
//    public void doSomething() throws NumberFormatException, ArithmeticException{
//    public void doSomething() {
//    public void doSomething() throws IOException{
    public void doSomething() throws NullPointerException {
        super.doSomething();
    }
}