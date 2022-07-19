package com.ssafy.oop2_5.polymorphism2;

public class Manager extends Employee {
    private String position;

    public Manager(String empno, String ename, int salary, String position) {
        super(empno, ename, salary);
        this.position = position;
    }

    public Manager() {

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Manager [position=" + position + ", toString()=" + super.toString() + "]";
    }

}
