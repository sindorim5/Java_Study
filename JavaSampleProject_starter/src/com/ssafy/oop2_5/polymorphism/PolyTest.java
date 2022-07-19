package com.ssafy.oop2_5.polymorphism;

class PolyTest {
    public static void main(String[] args) {
        Customer c = new Customer("홍길동", "서울", 20);
        System.out.println(c);

        MainCustomer mc = new MainCustomer("소나무", "부산", 21, "여행");
        System.out.println(mc);

        Customer cc = new MainCustomer("강나루", "인천", 25, "게임");
        System.out.println(cc);

    }
}
