package fr.emn.examination.view;

import java.util.ArrayList;
import java.util.HashMap;


public class CodeQuestion {
	
	private HashMap<String, String> segments;
	
	private ArrayList<String> 
	displayedCode,
	segmentIds;
	
	private JavaCode javaCode;
	
	private String id;
	
	public CodeQuestion(JavaCode javaCode, String id, ArrayList<String> displayedCode, ArrayList<String> segmentIds, HashMap<String, String> segments) {
		this.segments = segments;
		this.displayedCode = displayedCode;
		this.segmentIds = segmentIds;
		this.javaCode = javaCode;
		this.id = id;
	}

	public HashMap<String, String> getSegments() {
		return segments;
	}

	public ArrayList<String> getDisplayedCode() {
		return displayedCode;
	}

	public ArrayList<String> getSegmentIds() {
		return segmentIds;
	}
	
	public JavaCode getJavaCode() {
		return javaCode;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id+"\n"+displayedCode+"\n"+segmentIds+"\n"+segments;
	}
	
}
