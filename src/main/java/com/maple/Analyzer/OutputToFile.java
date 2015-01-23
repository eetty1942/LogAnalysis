package com.maple.Analyzer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputToFile {
	public void createFile(String result) {
		try {
			FileWriter fileWriter = new FileWriter("output.log");
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

			bufferWriter.write(result);
			bufferWriter.write("/r/n");
			bufferWriter.close();

		} catch (IOException e) {

		}
	}

}
