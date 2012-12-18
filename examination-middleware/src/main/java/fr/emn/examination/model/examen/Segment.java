package fr.emn.examination.model.examen;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Segment {
	public Segment(String typeCorrection, List<String> correction, int id) {
		super();
		this.typeCorrection = typeCorrection;
		this.correction = correction;
		this.id = id;
	}

	@XmlElement(required = true)
	private String typeCorrection;
	@XmlElement(required = true)
	private List<String> correction;
	@XmlAttribute(required = true)
	private int id;

	public Segment() {
	}

	public String getTypeCorrection() {
		return typeCorrection;
	}

	public void setTypeCorrection(String typeCorrection) {
		this.typeCorrection = typeCorrection;
	}

	public List<String> getCorrection() {
		return correction;
	}

	public void setCorrection(List<String> correction) {
		this.correction = correction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}