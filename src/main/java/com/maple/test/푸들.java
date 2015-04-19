package com.maple.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dog2")

public class 푸들 implements Dog{
	
	
	@Override
	public String bark() {
		return "낑낑";
	}
}
