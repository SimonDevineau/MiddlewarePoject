package fr.emn.examination.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JavaCodeParser {

	private static String
	QUESTION_START_REGEX = "<\\ *question\\ *id\\ *=\\ *\"(?<questionId>[a-zA-Z0-9]*)\"\\ *>",
	QUESTION_END_REGEX = "<\\ */\\ *question\\ *>",
	SEGMENT_START_REGEX = "<\\ *segment\\ *id\\ *=\\ *\"(?<segmentId>[a-zA-Z0-9]*)\"\\ *>",
	SEGMENT_END_REGEX = "<\\ */\\ *segment\\ *>";
	
	private JavaCode javaCode;

	public JavaCodeParser(String code) {
		javaCode = new JavaCode();
		parse(code);
	}

	public void parse(String code) {
		int currentIndex = 0;
		
		boolean 
		questionStarted = false,
		segmentStarted = false;
		
		HashMap<String, String> segments = null;
		
		ArrayList<String> 
		displayedCode = null,
		segmentIds = null;
		
		String 
		questionId = null, 
		segmentId = null;
		
		while(code.indexOf("/*", currentIndex)!=-1) {
			
			int 
			commentStartIndex = code.indexOf("/*", currentIndex),
			commentEndIndex = code.indexOf("*/", commentStartIndex);
			String 
			previousCode = code.substring(currentIndex, commentStartIndex),
			comment = code.substring(commentStartIndex+2, commentEndIndex);
			
			Matcher questionStart = Pattern.compile(QUESTION_START_REGEX).matcher(comment);
			Matcher segmentStart = Pattern.compile(SEGMENT_START_REGEX).matcher(comment);
			Matcher segmentEnd = Pattern.compile(SEGMENT_END_REGEX).matcher(comment);
			Matcher questionEnd = Pattern.compile(QUESTION_END_REGEX).matcher(comment);
			
			if(questionStart.find() && !questionStarted && !segmentStarted) {
				javaCode.getRoughCode().add(previousCode);
				questionStarted = true;
				questionId = questionStart.group("questionId");
				segments = new HashMap<String, String>();
				displayedCode = new ArrayList<String>();
				segmentIds = new ArrayList<String>();
			}

			else if(segmentStart.find() && questionStarted && !segmentStarted) {
				segmentStarted = true;
				displayedCode.add(previousCode);
				segmentId = segmentStart.group("segmentId");
				segmentIds.add(segmentId);
			}
			
			else if(segmentEnd.find() && questionStarted && segmentStarted) {
				segmentStarted = false;
				segments.put(segmentId, previousCode);
			}
			
			else if(questionEnd.find() && questionStarted && !segmentStarted) {
				questionStarted = false;
				javaCode.getQuestionIds().add(questionId);
				displayedCode.add(previousCode);
				CodeQuestion newQuestion = new CodeQuestion(javaCode, questionId, displayedCode, segmentIds, segments);
				javaCode.getQuestions().put(questionId, newQuestion);
				
			}
			
			currentIndex = commentEndIndex+2;
		}
		
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("Test.cor.java")));
			String s = "";
			while(br.ready())
				s+=(char)br.read();
			new JavaCodeParser(s);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
