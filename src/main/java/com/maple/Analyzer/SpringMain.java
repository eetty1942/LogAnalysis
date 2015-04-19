package com.maple.Analyzer;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");

		LogAnalyzer logAnalyzer = (LogAnalyzer) context.getBean("logAnalyzer");
		InputFromFile inputFromFile = (InputFromFile) context.getBean("inputFromFile");
		OutputToFile outputToFile = (OutputToFile) context.getBean("outputToFile");
		ValueComparator valueComparator = (ValueComparator) context.getBean("valueComparator");
		
		/*System.out.println(logAnalyzer);
		System.out.println(inputFromFile);
		System.out.println(outputToFile);
		System.out.println(valueComparator);*/
		
		try {
			outputToFile.createFile(inputFromFile.loadFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//LogAnalyzer logAnalyzer2 = (LogAnalyzer) context.getBean("log");

		//System.out.println(logAnalyzer2);
		
		//DogHouse dogHouse = (DogHouse) context.getBean("dogHouse");

		//System.out.println(dogHouse);
	}
}
