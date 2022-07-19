package com.ssafy.oop3_5.collection;

import java.util.*;

class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("seoul");
        set.add("korea");
        set.add("123");
        set.add("korea");

        for (String s : set) { // 3개의 객체가 순서 없이 출력된다.
            System.out.println(s);
        }
        
        // iterator 사용
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next()); // .toString()
        }
    }
}
