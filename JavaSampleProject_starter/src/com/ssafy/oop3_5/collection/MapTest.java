package com.ssafy.oop3_5.collection;

import java.util.*;

class MapTest {
    public static void main(String[] args) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("city", "seoul");
        list.put("na", "korea");
        list.put("ho", "123");
        list.put("na2", "korea");

        System.out.println("city:" + list.get("city"));
        Iterator<String> i = list.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            String value = list.get(key);
            // 처리
            System.out.println(key + ":" + value);
        }

    }
}


