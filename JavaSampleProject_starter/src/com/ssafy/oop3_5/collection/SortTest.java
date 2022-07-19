package com.ssafy.oop3_5.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortTest {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동1", 20);
        Person p2 = new Person("홍길동2", 25);
        Person p3 = new Person("홍길동3", 22);
        
        Set<Person> set= new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);

        List<Person> list= new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
        

//        Comparator 구현
        
        System.out.println(list);

    }
}

class Person {     //Comparable<Person>
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}
