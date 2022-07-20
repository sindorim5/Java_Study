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

		System.out.println(set);

		// iterator 사용
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next()); // .toString()
		}

//		Student s1 = new Student("홍길동", 20);
//		Student s2 = new Student("홍길동", 21);
//		Student s3 = new Student("홍길동", 21);
//
//
//		Set<Student> sSet = new HashSet<>();
//		sSet.add(s1);
//		sSet.add(s2);
//		sSet.add(s3);
//		System.out.println(sSet);
	}
}

class Student {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
//		System.out.println("hashCode...");
//		return age;
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals...");
//		Student other = (Student) obj;
//		if (this.name.equals(other.name) && this.age == other.age)
//			return true;
//		else
//			return false;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
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
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
