package com.ssafy.oop3_3.inner;

class Outer {
    public void outerMethod() {
        System.out.println("outerMethod()..........");
        Inner invar = new Inner();
        invar.innerMethod();
    }

    class Inner {
        void innerMethod() {
            System.out.println("innerMethod()..........");
        }
    }

    public static void main(String[] args) {
        Outer ou = new Outer();
        ou.outerMethod();
    }
}
