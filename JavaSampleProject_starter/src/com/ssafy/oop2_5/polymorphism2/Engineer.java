package com.ssafy.oop2_5.polymorphism2;

public class Engineer extends Employee {
    private String skill;

    public Engineer(String empno, String ename, int salary, String skill) {
        super(empno, ename, salary);
        this.skill = skill;
    }

    public Engineer() {

    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Engineer [skill=" + skill + ", toString()=" + super.toString() + "]";
    }

}
