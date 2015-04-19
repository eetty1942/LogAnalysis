package com.maple.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		
		DogHouse dogHouse = context.getBean(DogHouse.class);
		dogHouse.singDogSound();
	}
}
