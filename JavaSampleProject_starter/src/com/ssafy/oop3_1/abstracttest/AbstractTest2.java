package com.ssafy.oop3_1.abstracttest;

abstract class Person {
    public abstract int getKoreanScore();
    public abstract int getEnglishScore();

    public double getAverage() {
        return (getKoreanScore()+getEnglishScore())/2;
        
    }
}

class Student extends Person {
    private int koreanScore;
    private int englishScore;
    public Student(int koreanScore, int englishScore) {
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
    }
    public int getKoreanScore() {return koreanScore;}
    public int getEnglishScore() {return englishScore;}
    
}

class AbstractTest2 {
    public static void main(String[] a) {
        Person [] person = new Person[5];
        person[0] = new Student(100, 80);
        person[1] = new Student(90, 80);
        person[2] = new Student(70, 80);
        person[3] = new Student(80, 80);
        person[4] = new Student(100, 100);
        
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].getAverage());
        }
    
    }
}


