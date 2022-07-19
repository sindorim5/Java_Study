package com.ssafy.oop2_5.polymorphism2;

public class EmployeeMgr {
    private Employee[] emplist;
    private int empIndex = 0;

    public EmployeeMgr() {
        emplist = new Employee[100];
    }

    private int indexOf(String empno) {
        for (int i = 0; i < emplist.length; i++) {
            if (empno.equals(emplist[i].getEmpno())) {
                return i;
            }
        }

        return -1; // 동일한 empno 없음
    }

    public void addEmployee(Employee emp) {
        emplist[empIndex] = emp;
        empIndex++;
    }

    public void updateEmployee(Employee emp) {
        int index = indexOf(emp.getEmpno());
        // index -1이면...오류처리...

        Employee e = searchEmployee(emp.getEmpno());
        e.setEname(emp.getEname());
        e.setSalary(emp.getSalary());
    }

    public void deleteEmployee(String empno) {
        int index = indexOf(empno);
        emplist[index] = emplist[--empIndex];
    }

    public Employee searchEmployee(String empno) {
        int index = indexOf(empno);
        if (index != -1) {
            // 있다
            return emplist[index];
        }
        return null; // 없다
    }

    public Employee[] getEmployees() {
        return null;
    }

    public void printAllEmployee() {
        for (int i = 0; i < empIndex; i++) {
            System.out.println(emplist[i]);
        }
    }

}