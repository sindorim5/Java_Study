package com.ssafy.oop3_5.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortTest {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동1", 20);
		Person p2 = new Person("홍길동2", 25);
		Person p3 = new Person("홍길동3", 22);

		Set<Person> set = new HashSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println("set");
		System.out.println(set);

		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println("list");
		System.out.println(list);
//		0.
		Collections.sort(list);
		System.out.println("++++++++++++++");
		System.out.println(list);

//		1.
//		Comparator<Person> c = new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return this.getAge() - o.getAge();
//			}
//		};
//		Collections.sort(list, c);

//		2.
//		class temp implements Comparator<Person> {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getAge() - o2.getAge();
//			}
//		}
//		Collections.sort(list, new temp());

//        Comparator 구현
//		3.
//		Collections.sort(list, new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});

		System.out.println("++++++++++++++");
		System.out.println(list);

	}
}

class Person implements Comparable<Person> {
	private String name;
	private int age;

	@Override
//	0.
	public int compareTo(Person o) {
		// 내가 크면 +, 같으면 0, 작으면 -
//		return o.getAge() - this.getAge();	  내림차순
//		return this.getAge() - o.getAge();    오름차순
		return ((Integer) this.getAge()).compareTo(o.getAge());
	}

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
