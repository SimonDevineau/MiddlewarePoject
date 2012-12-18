package fr.emn.examination.model.examen;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Protocole {
	public Protocole(String value, String nbEssais, String version,
			String duree, String nbPoints) {
		super();
		this.value = value;
		this.nbEssais = nbEssais;
		this.version = version;
		this.duree = duree;
		this.nbPoints = nbPoints;
	}

	@XmlValue
	private String value;
	@XmlAttribute
	private String nbEssais;
	@XmlAttribute
	private String version;
	@XmlAttribute
	private String duree;
	@XmlAttribute(required = true)
	private String nbPoints;

	public Protocole() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNbEssais() {
		return nbEssais;
	}

	public void setNbEssais(String nbEssais) {
		this.nbEssais = nbEssais;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(String nbPoints) {
		this.nbPoints = nbPoints;
	}
}