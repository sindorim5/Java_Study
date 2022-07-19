package com.ssafy.oop2_4.overriding;

//class Parent {
//    int number = 10;
//
//    void over() {
//        System.out.println("Parent class!");
//    }
//
//    void mParent() {
//        System.out.println("Parent method");
//    }
//
//}
//
//class Child extends Parent {
//    int number = 20;
//
//    void over() { // Overriding
//        System.out.println("Child class!");
//    }
//
//    void mChild() {
//        System.out.println("Child method");
//    }
//}
//
//class newPolyTest {
//    public static void main(String a[]) {
//        Parent parent = new Parent();
//        System.out.println(parent.number);
//        parent.over();
//        parent.mParent();
//
//        Child child = new Child();
//        System.out.println(child.number);
//        child.over();
//        child.mParent();
//        child.mChild();
//
//        Parent parent2 = new Child(); // type polymorphism
//        System.out.println(parent2.number);
//        parent2.over();
//        parent2.mParent();
////        parent2.mChild();
//
//        Child child2 = (Child) parent2;
//        child2.mChild();
//
//        Parent[] p = new Parent[10];
//        p[0] = parent;
//        p[1] = child;
//
//        p[0].over();
//        p[1].over();
//
//        // immutable 모든 object
//        // 단점 o[i].xxx : xxx object로 호출 할 수 없음
//
//        Object[] o = new Object[10];
//        o[0] = parent;
//        o[1] = child;
//
//    }
//}