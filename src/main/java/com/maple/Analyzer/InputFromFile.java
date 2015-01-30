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
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputFromFile {
	
	private	FileInputStream fstream = null;
	private String line = null;
	
	private String stateCode;
	private String apiServiceId;
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
	private ValueComparator hashComparator = null;
	
	private TreeMap<String, Integer> serviceSorted = null;
	private TreeMap<String, Integer> apiSorted = null;
	private TreeMap<String, Integer> timeSorted = null;
	
	public String loadFile() throws IOException {
		fstream = null;
		
		try {
			File inFile = new File("input.log");
			fstream = new FileInputStream(inFile);
			
			DataInputStream inputStream = new DataInputStream(fstream);
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			
			while ((line = bufferReader.readLine()) != null && line != "") {
				
				stateCode = logAnalyzer.analyzeStateCode(line);
				apiServiceId = logAnalyzer.analyzeService(line);
				browser = logAnalyzer.analyzeBrowser(line);
				mostApiKey = logAnalyzer.analyzeApikey(line);
				time = logAnalyzer.analyzeTime(line);
				
				if(stateCode.equals("[10]")) {
					numberOfStateCode[0]++;
				}
				else if(stateCode.equals("[200]")) {
					numberOfStateCode[1]++;
				}
				else if(stateCode.equals("[404]")) {
					numberOfStateCode[2]++;
				}

				if(browser.equals("[IE]")) {
					numberOfBrowser[0]++;
				}
				else if(browser.equals("[Firefox]")) {
					numberOfBrowser[1]++;
				}
				else if(browser.equals("[Safari]")) {
					numberOfBrowser[2]++;
				}
				else if(browser.equals("[Chrome]")) {
					numberOfBrowser[3]++;
				}
				else if(browser.equals("[Opera]")) {
					numberOfBrowser[4]++;
				}
				
				if(apiServiceHashmap.containsKey(apiServiceId)){
					int value=0;
					value = apiServiceHashmap.get(apiServiceId);
					apiServiceHashmap.put(apiServiceId, ++value);
				}else{
					apiServiceHashmap.put(apiServiceId, 1);
				}
				
				if(apiHashmap.containsKey(mostApiKey)){
					//해당키가 있을경우
					int value=0;
					value = apiHashmap.get(mostApiKey);
					apiHashmap.put(mostApiKey, ++value);
				}else {
					apiHashmap.put(mostApiKey, 1);
				}
				
				if(timeHashmap.containsKey(time)){
					int value=0;
					value = timeHashmap.get(time);
					timeHashmap.put(time, ++value);
				}else{
					timeHashmap.put(time, 1);
				}
			}
			
			hashComparator = new ValueComparator(apiServiceHashmap);
			serviceSorted = new TreeMap<String, Integer>(hashComparator);
			serviceSorted.putAll(apiServiceHashmap);
			
			Iterator<String> serviceIterator = serviceSorted.keySet().iterator();

			for(int index=0; index<3 ; index++){
				rank[index] = (String) serviceIterator.next();
			}
			
			hashComparator = new ValueComparator(apiHashmap);
			apiSorted = new TreeMap<String, Integer>(hashComparator);
			apiSorted.putAll(apiHashmap);
			
			Iterator<String> iterator = apiSorted.keySet().iterator();

			mostApiKey = (String) iterator.next();
			
			hashComparator = new ValueComparator(timeHashmap);
			timeSorted = new TreeMap<String, Integer>(hashComparator);
			timeSorted.putAll(timeHashmap);
			Iterator<String> timeIterator = timeSorted.keySet().iterator();
			
			peakTime = (String) timeIterator.next();
				
		} catch (FileNotFoundException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,ex);
		}
		String result;
		
		result = "10  : "+numberOfStateCode[0] + "\r\n" +
				"200 : "+numberOfStateCode[1] + "\r\n" +
				"404 : "+numberOfStateCode[2] +"\r\n" +
				 "\r\n" +
				"1st Service : " + rank[0] + "\r\n" +
				"2nd Service : " + rank[1] + "\r\n" +
				"3rd Service : " + rank[2] + "\r\n" +
				 "\r\n" +
				"IE         : "+(double)numberOfBrowser[0]/sum*100+"%" + "\r\n" +
				"Firefox    : "+(double)numberOfBrowser[1]/sum*100+"%" + "\r\n" +
				"Safari     : "+(double)numberOfBrowser[2]/sum*100+"%" + "\r\n" +
				"Chrome     : "+(double)numberOfBrowser[3]/sum*100+"%" + "\r\n" +
				"Opera      : "+(double)numberOfBrowser[4]/sum*100+"%" + "\r\n" +
				"\r\n" +
				"apikey     : " + mostApiKey +"\r\n" +
				"\r\n" +
				"peak time  : " + peakTime;
		return result;
	}
}
	
	
	
	

