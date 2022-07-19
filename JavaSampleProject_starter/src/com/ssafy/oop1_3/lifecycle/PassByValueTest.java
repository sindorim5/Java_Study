package com.ssafy.oop1_3.lifecycle;

class PassByValue {
	public int primitive(int data) {
		data += 5;
		return data;
	}

	public void reference(Member data) {
		data.email = "kkk@ssafy.com";
	}
}

public class PassByValueTest {
	public static void main(String[] args) {
		PassByValue pv = new PassByValue();
		int data = 5;
		pv.primitive(data);
		System.out.printf("primitive(data) 호출후의 data:%d\n", data); // 5
		data = pv.primitive(data);
		System.out.printf("primitive(data) 리턴 후 data:%d\n", data); // 10

		Member member = new Member("홍길동", 20, "aaa@ssafy.com");
		pv.reference(member);
		System.out.printf("reference(Member data) 호출후 :%s\n", member);

	}
}

class Member {
	String name;
	int age;
	String email;

	public Member() {
	}

	public Member(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String toString() {
		String info = name + "\t|" + age + "\t|" + email;
		return info;
	}
}
