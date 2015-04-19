package com.maple.test;

import org.springframework.stereotype.Component;

@Component("dog1")
public class 진돗개  implements Dog{

	private int age;

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public 진돗개(int age) {
		this.age = age;
	}
	
	@Override
	public String bark() {
		return "으르렁";
	}

}
