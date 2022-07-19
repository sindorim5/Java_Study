package com.ssafy.oop1_4.modifier;

class StaticVarTest {
    static int count = 0;// static변수는 객체들간 공유되는 변수이다.
    int instanceVariable = 0; // instance Variable

    void go() {
        int num = 0;
        count++;
        instanceVariable++;
        num++;
        System.out.println("count=" + count + "\tb=" + instanceVariable + "\tnum=" + num);
    }

    public static void main(String[] args) {
        System.out.println("StaticVarTest.count=" + StaticVarTest.count);
        StaticVarTest a1 = new StaticVarTest();
        StaticVarTest a2 = new StaticVarTest();
        a1.go();
        a2.go();
        a1.instanceVariable += 100;
        a1.count += 100;
        System.out.println("a1.count=" + a1.count + " b=" + a1.instanceVariable);
        System.out.println("a2.count=" + a2.count + " b=" + a2.instanceVariable);
        System.out.println("StaticVarTest.count=" + StaticVarTest.count);
    }
}