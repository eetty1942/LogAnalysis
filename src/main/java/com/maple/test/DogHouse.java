package com.maple.test;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogHouse {
	
	@Resource(name = "dog1")
	private Dog dog;
	
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public void singDogSound() {
		System.out.println(dog.bark());
		
	}

}
