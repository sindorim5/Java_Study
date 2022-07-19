package com.ssafy.oop3_5.collection;

import java.util.*;

class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("seoul");
        list.add("korea");
        list.add("123");
        list.add("korea");

        System.out.println(list);

        for (String s : list) { // 순서대로 4개의 객체가 출력된다.
            System.out.println(s);
        }

        // iterator 사용
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());// toString()
        }
    }
}



