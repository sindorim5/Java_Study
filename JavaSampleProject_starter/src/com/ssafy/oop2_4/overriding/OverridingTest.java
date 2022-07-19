package com.ssafy.oop2_4.overriding;

class Parent {
    int number = 10;

    void over() {
        System.out.println("Parent class!");
    }

    void mParent() {
        System.out.println("Parent method");
    }

}

class Child extends Parent {
    int number = 20;

    void over() { // Overriding
        System.out.println("Child class!");
    }

    void mChild() {
        System.out.println("Child method");
    }
}

class OverridingTest {
    public static void main(String a[]) {
        Parent parent = new Parent();
        System.out.println(parent.number);
        parent.over();
        parent.mParent();

        Parent child = new Child();
        System.out.println(child.number);
        child.over();
        child.mParent();
//        child.mChild();
    }
}