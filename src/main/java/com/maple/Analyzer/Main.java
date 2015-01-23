package com.maple.Analyzer;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
	
		InputFromFile inputFromeFile = new InputFromFile();
		OutputToFile outputToFile = new OutputToFile();
		
		try {
			outputToFile.createFile(inputFromeFile.loadFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
