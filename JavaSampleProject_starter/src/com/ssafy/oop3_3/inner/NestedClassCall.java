package com.ssafy.oop3_3.inner;

class NestedClassCall {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner in = out.new Inner();
        in.innerMethod();
    }
}
