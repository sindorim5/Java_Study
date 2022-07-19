package com.ssafy.oop3_5.collection;

import java.util.ArrayList;

public class ArrayListTest {
    private ArrayList<String> list;

    public ArrayListTest() {
        list = new ArrayList<>();
    }

    private void insert(String s) {
        list.add(s);
        System.out.println("입력 되었습니다.");
    }

    private void update(String before, String after) {
        if(!list.contains(before)) {
            System.out.println("해당 객체가 없습니다. ");
        } else {
            int index = list.indexOf(before);
            list.set(index, after);
            System.out.println("수정 되었습니다.");
        }
        printList();
    }

    private void delete(int k) {
        list.remove(k);
        System.out.println("삭제 되었습니다.");
        printList();
    }

    private void search(String object) {
        if (list.contains(object)) {
            int index = list.indexOf(object);
            System.out.println("해당 객체가 " + (index + 1) + "번째에 있습니다.");
        } else {
            System.out.println("해당 객체가 없습니다.");
        }
    }

    private void printList() {
        int length = list.size(); // 실제 데이터가 들어있는 크기를 구한다.
        System.out.println("전체 " + length + "건의 데이터가 있습니다. ");
        for (String string : list) {
            System.out.println(string.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayListTest arrayTest = new ArrayListTest();

        arrayTest.insert(new String("seoul"));
        arrayTest.insert(new String("daegu"));
        arrayTest.insert(new String("gumi"));
        arrayTest.insert(new String("kwangjoo"));
        arrayTest.insert(new String("buwolkyoung"));
        arrayTest.printList();
        
        arrayTest.search("seoul");

        arrayTest.update("kwangjoo", "kwangju");

        arrayTest.delete(2);
    }
}

