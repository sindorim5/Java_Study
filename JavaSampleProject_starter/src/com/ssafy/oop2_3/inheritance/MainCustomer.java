package com.ssafy.oop2_3.inheritance;

class MainCustomer extends Customer {
    private String hobby;

    public MainCustomer() {
    }

    public MainCustomer(String name, int age) {
        this(name, null, age, null); // 첫번째 줄에 들어가야 한다.
//        super.setName(name);
//        super.setAddress(null);
//        super.setAge(age);
//        setHobby(null);
    }

    public MainCustomer(String name, String address, int age, String hobby) {
        super(name, address, age); // 첫번째 줄에 들어가야 한다.
//        setName(name);
//        setAddress(address);
//        setAge(age);
        setHobby(hobby);
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public String toString() {
        String str = "이름 : " + getName() + "\t주소 : " + getAddress() + "\t나이 : " + getAge() + "\t취미 : " + getHobby();
        // String str = super.toString()+"\t취미 : "+hobby;
        return str;
    }

}
