package com.maple.Analyzer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.ArrayList;

public class InputFromFile {
	
	private	FileInputStream fstream = null;
	private String line = null;
	
	private String stateCode;
	private String apiServiceId;
	private String apiKey;
	private String mostApiKey;
	private String browser;
	private String time;
	private String peakTime;
	private String rank[] = new String[]{null, null, null};
	private int sum;
	
	private int numberOfStateCode[] = new int[]{0,0,0};
	private int numberOfBrowser[]	 = new int[]{0,0,0,0,0};
	
	private HashMap<String, Integer> apiServiceHashmap = new HashMap<String, Integer>();
	private HashMap<String, Integer> apiHashmap = new HashMap<String, Integer>();
	private HashMap<String, Integer> timeHashmap = new HashMap<String, Integer>();
	
	private LogAnalyzer logAnalyzer = new LogAnalyzer();
	private ValueComparator valueComparator = new ValueComparator();
	
	public String loadFile() throws IOException {
		fstream = null;
		
	}
	
	
	
	
}
