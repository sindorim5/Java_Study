package com.ssafy.oop2_5.polymorphism2;

public class Employee {
    private String empno;
    private String ename;
    private int salary;

    public Employee(String empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public Employee() {

    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + "]";
    }

}
