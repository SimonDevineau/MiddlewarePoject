package fr.emn.services.compilation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {

	

	@XmlElement
	private String error = "";
	
	@XmlElement
	private boolean succeed = false;
	

	public boolean hasSucceeded() {
		return succeed;
	}

	public void setSucceeded(boolean succeed) {
		this.succeed = succeed;
	}

	public Result() {
		super();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
