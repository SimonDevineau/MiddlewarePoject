package fr.emn.examination.model.examen;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;

public class Case {
	public Case(String value, BigInteger id, boolean correction) {
		super();
		this.value = value;
		this.id = id;
		this.correction = correction;
	}

	@XmlValue
	private String value;
	@XmlSchemaType(name = "positiveInteger")
	@XmlAttribute(required = true)
	private BigInteger id;
	@XmlAttribute(required = true)
	private boolean correction;

	public Case() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public boolean isCorrection() {
		return correction;
	}

	public void setCorrection(boolean correction) {
		this.correction = correction;
	}
}