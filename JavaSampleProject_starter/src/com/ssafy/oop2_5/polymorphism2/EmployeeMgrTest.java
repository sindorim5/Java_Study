package com.ssafy.oop2_5.polymorphism2;

public class EmployeeMgrTest {

    public static void main(String[] args) {
        EmployeeMgr mgr = new EmployeeMgr();

        // add
        Employee e1 = new Employee("emp1", "홍길동", 5000);
        Employee e2 = new Engineer("emp2", "김싸피", 6000, "알고리즘");
        Employee e3 = new Manager("emp3", "김삼성", 7000, "과장");

        mgr.addEmployee(e1);
        mgr.addEmployee(e2);
        mgr.addEmployee(e3);
        // 중복체크가 안 됨
//        mgr.addEmployee(new Manager("emp3", "김삼성", 7000, "과장"));
        mgr.printAllEmployee();

        System.out.println();

        // search
        e1 = mgr.searchEmployee("emp1"); // Employee
        e2 = mgr.searchEmployee("emp2"); // Engineer
        System.out.println(e1);
        System.out.println(e2);

        System.out.println();
        // update
        e1.setSalary(6000);
        mgr.updateEmployee(e1);
        mgr.printAllEmployee();

        System.out.println();
        // delete
        mgr.deleteEmployee("emp1");
        mgr.printAllEmployee();

    }

}
