package fr.emn.examination.model.examen;

import javax.xml.bind.annotation.XmlElement;

public class Destination {
	public Destination(String uv, String module, String coefficient) {
		super();
		this.uv = uv;
		this.module = module;
		this.coefficient = coefficient;
	}

	@XmlElement(name = "UV")
	private String uv;
	private String module;
	private String coefficient;

	public Destination() {
	}

	public String getUv() {
		return uv;
	}

	public void setUv(String uv) {
		this.uv = uv;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}
}