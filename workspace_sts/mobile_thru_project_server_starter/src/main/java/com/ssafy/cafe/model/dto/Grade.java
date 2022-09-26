package com.ssafy.cafe.model.dto;

public class Grade {
    public String img;
    public String title;
    public int step;
    public int to;
     
    public Grade(int stampNum) {
        if (stampNum < 50) {
            img = "seeds.png";
            title = "씨앗";
            step = stampNum / 10 + 1;
            to = 10 - stampNum % 10;
        } else if (stampNum < 125) {
            img = "flower.png";
            title = "꽃";
            step = (stampNum - 50) / 15;
            to = 15 - (stampNum - 50) % 15;
        } else if (stampNum < 225) {
            img = "coffee_fruit.png";
            title = "열매";
            step = (stampNum - 125) / 20;
            to = 20 - (stampNum - 125) % 20;
        } else if (stampNum < 350) {
            img = "coffee_bean.png";
            title = "커피콩";
            step = (stampNum - 225) / 25;
            to = 25 - (stampNum - 225) % 25;
        } else {
            img = "coffee_tree.png";
            title = "커피나무";
            step = 0;
            to = 0;
        }
    }
}