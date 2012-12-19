package fr.emn.services.compilation.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fr.emn.services.compilation.Result;

@XmlRootElement
public class ExecuteResult extends Result {
	
	@XmlElement
	private int timeElapsed;
	
	@XmlElement
	private String result = "";

	public int getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(int timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ExecuteResult() {
		super();
	}
	
	
}
