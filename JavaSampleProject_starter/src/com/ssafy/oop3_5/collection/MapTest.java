package com.ssafy.oop3_5.collection;

import java.util.*;

class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("city", "seoul");
        map.put("city", "busan");
        map.put("city", "daegu");	// key는 유일해서
        map.put("city", "gumi");	// 값을 덮어 써버림
        
        
        map.put("na", "korea");
        map.put("ho", "123");
        map.put("na2", "korea");

        System.out.println("city:" + map.get("city"));
        System.out.println();
        Iterator<String> i = map.keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            String value = map.get(key);
            // 처리
            System.out.println(key + ":" + value);
        }

    }
}


