package com.maple.Analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service //("log")
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
	
	public String analyzeStateCode(String data){
		index=0;
		
		while(index!=3){
			String stateLogInfo = String.format(typeOfStateLog[index++]);
			Pattern logPattern = Pattern.compile(stateLogInfo);
			Matcher patternMatch = logPattern.matcher(data);
			
			if(patternMatch.find()){
				String matchResult = patternMatch.group(0).trim();
				return matchResult;
			}
		}
		return ""; 
	}
	
	public String analyzeService(String data){
		index=0;
		
		while(index!=6){
			String ServiceInfo = String.format(logRequest[index++]);
			Pattern logPattern = Pattern.compile(ServiceInfo);
			Matcher logPatternMatches = logPattern.matcher(data);
			
			if(logPatternMatches.find()){
				String matchResult = logPatternMatches.group(0).trim();
				return matchResult;
			}
		}
		return "";
	}
	
	public String analyzeBrowser(String data){
		index=0;
		
		while(index!=5){
			String ServiceInfo = String.format(typeOfBrowser[index++]);
			Pattern logPattern = Pattern.compile(ServiceInfo);
			Matcher logPatternMatches = logPattern.matcher(data);
			
			if(logPatternMatches.find()){
				String matchResult = logPatternMatches.group(0).trim();
				return matchResult;
			}
		}
		return "";
	}
	
	public String analyzeApikey(String data){		
		apikey = "apikey=.{4}";
		
		String ServiceInfo = String.format(apikey);
		Pattern logPattern = Pattern.compile(ServiceInfo);
		Matcher logPatternMatches = logPattern.matcher(data);
		
		if(logPatternMatches.find()){
			String matchResult = logPatternMatches.group(0).trim().replace("apikey=","");
			return matchResult;
		}
		
		return "";
	}
	public String analyzeTime(String data){
		time = "d{4}-d{2}-d{2}" + " " + "d{2}:d{2}";
		
		String timeInfo = String.format(time);
		Pattern timePattern = Pattern.compile(timeInfo);
		Matcher timePatternMatches = timePattern.matcher(data);
		if(timePatternMatches.find()){
			String matchResult = timePatternMatches.group(0).trim();
			return matchResult;
		}
		return "";
	}
}
