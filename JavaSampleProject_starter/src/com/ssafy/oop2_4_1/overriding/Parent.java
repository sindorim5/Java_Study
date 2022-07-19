package com.ssafy.oop2_4_1.overriding;

class Parent {
    private String name;

    public Parent() {

    }

    public Parent(String name) {
//       super();
//       컴파일러는 클래스에 생성자가 하나도 정의되어 있지 않으면, 자동으로 기본 생성자를 추가해줌
        this.name = name;
        go();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void go() { // override
        System.out.println("super.go" + name);
    }   // 호출되고 싶으면 private로 설정해서 override를 못하게 막아야 함

}

class Child extends Parent {
    int age;

    public Child(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public void go() {
        System.out.println("child.go");
    }

}