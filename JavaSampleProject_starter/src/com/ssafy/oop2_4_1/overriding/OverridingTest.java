package com.ssafy.oop2_4_1.overriding;

class OverridingTest {
    public static void main(String a[]) {
        Parent p = new Parent("김싸피");
        Child c = new Child("홍길동", 20);
//        Parent p2 = new Parent();

        OverridingTest test = new OverridingTest();
        test.go(p);
        test.go(c);

    }

    public void go(Parent p) {
        // 나이를 출력
        // p.age 안됨...age는 Child의 member
        if (p instanceof Child) {
            // 타입캐스팅 필요
            Child c = (Child) p;
            System.out.println(c.age);
        } else if (p instanceof Parent) {
            // 상속의 역순으로 해야 정상적으로 실행될 것
        } else if (p instanceof Object) {

        }
    }
}