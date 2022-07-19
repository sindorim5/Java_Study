package com.ssafy.oop2_6.typecasting;

class CastTest {
    public static void main(String[] args) {
        CastTest pt = new CastTest();
        Customer customer = new Customer("홍길동", "서울", 20);
        System.out.println(customer);
        MainCustomer mc = new MainCustomer("소나무", "부산", 21, "여행");
        System.out.println(mc);
        Customer cc = new MainCustomer("강나루", "인천", 25, "게임");
        System.out.println(cc);

        pt.compute(customer);
        pt.compute(mc);
        pt.compute(cc);

    }

    public void compute(Customer customer) {
        if (customer instanceof MainCustomer) {
            MainCustomer mc = (MainCustomer) customer;
            System.out.println("주요고객에 대한 처리 수행..." + mc.getName() + "  취미:" + mc.getHobby());
        } else {
            System.out.println("고객에 대한 처리 수행..." + customer.getName());
        }
    }

}
