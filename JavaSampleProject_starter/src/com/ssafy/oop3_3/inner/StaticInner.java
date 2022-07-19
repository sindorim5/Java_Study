package com.ssafy.oop3_3.inner;

public class StaticInner {
    public void outerMethod() {
        System.out.println("outerMethod()..........");
    }

    public static class Inner {
        public static void innerStaticMethod() {
            System.out.println("innerStaticMethod()..........");
        }

        void innerMethod() {
            System.out.println("innerMethod()..........");
        }
    }

    public static void main(String[] args) {
        StaticInner.Inner.innerStaticMethod(); // static method call
        StaticInner.Inner in = new StaticInner.Inner();
        in.innerMethod();
    }
}
