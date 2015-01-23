package com.maple.Analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {

	private String[] typeOfStateLog = new String[]
			{"[200]","[10]","[404]"};
	private String[] logRequest = new String[]
			{"blog","book","image","knowledge","news","vclip"};
	private String[] typeOfBrowser = new String[]
			{"[IE]","[Firefox]","[Safari]","[Chrome]","[Opera]"};
	private String apikey;
	private String time;
	public int index;
	
	public String analyzeStateCode(String info){
		index=0;
		
		while(index!=3){
			String stateLogInfo = String.format(typeOfStateLog[index++]);
			Pattern logPattern = Pattern.compile(stateLogInfo);
			Matcher logPatternMatches = logPattern.matcher(info);
			
			if(logPatternMatches.find()){
				String matchResult = logPatternMatches.group(0).trim();
				return matchResult;
			}
		}
		return ""; 
	}
	
	public String analyzeService(String info){
		index=0;
		
		while(index!=6){
			String ServiceInfo = String.format(logRequest[index++]);
			Pattern logPattern = Pattern.compile(ServiceInfo);
			Matcher logPatternMatches = logPattern.matcher(info);
			
			if(logPatternMatches.find()){
				String matchResult = logPatternMatches.group(0).trim();
				//System.out.println("matchResult = " + matchResult);
				return matchResult;
			}
		}
		return "";
	}
	
	public String analyzeBrower(String info){
		index=0;
		
		while(index!=5){
			String ServiceInfo = String.format(typeOfBrowser[index++]);
			Pattern logPattern = Pattern.compile(ServiceInfo);
			Matcher logPatternMatches = logPattern.matcher(info);
			
			if(logPatternMatches.find()){
				String matchResult = logPatternMatches.group(0).trim();
				//System.out.println("matchResult = " + matchResult);
				return matchResult;
			}
		}
		return "";
	}
	
	public String analyzeApikey(String info){		
		apikey = "apikey=.{4}";
		
		String ServiceInfo = String.format(apikey);
		Pattern logPattern = Pattern.compile(ServiceInfo);
		Matcher logPatternMatches = logPattern.matcher(info);
		
		if(logPatternMatches.find()){
			String matchResult = logPatternMatches.group(0).trim().replace("apikey=","");
			//System.out.println("matchResult = " + matchResult);
			return matchResult;
		}
		
		return "";
	}
	public String analyzeTime(String info){
		time = "d{4}-d{2}-d{2}" + " " + "d{2}:d{2}";
		
		String timeInfo = String.format(time);
		Pattern timePattern = Pattern.compile(timeInfo);
		Matcher timePatternMatches = timePattern.matcher(info);
		if(timePatternMatches.find()){
			String matchResult = timePatternMatches.group(0).trim();
			return matchResult;
		}
		return "";
	}
}
