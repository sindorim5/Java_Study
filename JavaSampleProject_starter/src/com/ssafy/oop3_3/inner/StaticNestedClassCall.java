package com.ssafy.oop3_3.inner;

class StaticNestedClassCall {
    public static void main(String[] args) {
        StaticInner.Inner.innerStaticMethod();// static method call

        StaticInner.Inner in = new StaticInner.Inner();
        in.innerMethod();
    }
}
