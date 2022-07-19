package com.ssafy.oop1_1.constructor;

class MyDate {
    int year;
    int month;
    int day;
    
    public MyDate(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }
    
    public MyDate() {
        
    }	// default 생성자, 없으면 new MyDate()가 오류가 생김.
}
