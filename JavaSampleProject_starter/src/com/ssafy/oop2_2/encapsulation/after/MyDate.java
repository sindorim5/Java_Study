package com.ssafy.oop2_2.encapsulation.after;

class MyDate {
    private int year;
    private int month;
    private int day;

    /** 년도 입력 메소드 */
    public void setYear(int y) {
        // 입력된 y값이 2000-2050 사이값인지 check
        if (y >= 2000 && y <= 2050)
            year = y;
        else
            System.out.println(year + "값은 올바른 값이 아님!!");
    }

    /** 월 입력 메소드 */
    public void setMonth(int m) {
        // 입력된 m값이 1-12사이 값이지 check
        if (m >= 1 && m <= 12)
            month = m;
        else
            System.out.println(month + "은 월의 범위를 넘습니다");
    }

    /** 일자 입력 메소드 */
    public void setDay(int d) {
        // 입력된 d값이 각 월의 마지막 날과 1사이 값인지 check
        if (month == 0) {
            System.out.println("월을 먼저 입력하세요");
            return;
        }
        int endDay = 0;
        switch (month) {
        case 2:
            endDay = 28;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            endDay = 30;
            break;
        default:
            endDay = 31;
        }
        if (d >= 1 && d <= endDay)
            day = d;
        else
            System.out.println(d + "는 올바른 날짜가 아님!!");
    }

    /** 년도 반환 메소드 */
    public int getYear() {
        return year;
    }

    /** 월 반환 메소드 */
    public int getMonth() {
        return month;
    }

    /** 일자 반환 메소드 */
    public int getDay() {
        return day;
    }

    /** 객체의 정보를 문자열로 반환 */
    public String toString() {
        if (year == 0 || month == 0 || day == 0)
            return "올바른 데이타가 입력되지 않았습니다.";
        else
            // 객체의 내용에 대한 정보를 문자열로 return
            return (year + "년   " + month + "월  " + day + "일");
    }
}
