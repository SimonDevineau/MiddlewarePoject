package fr.emn.examination.model.examen;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;

public class Choix {
	public Choix(String value, BigInteger id) {
		super();
		this.value = value;
		this.id = id;
	}

	@XmlValue
	private String value;
	@XmlSchemaType(name = "positiveInteger")
	@XmlAttribute(required = true)
	private BigInteger id;

	public Choix() {
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
}