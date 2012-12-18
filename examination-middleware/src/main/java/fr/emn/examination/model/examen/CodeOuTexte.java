package fr.emn.examination.model.examen;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CodeOuTexte {
	public CodeOuTexte(List<Segment> segment) {
		super();
		this.segment = segment;
	}

	@XmlElement(required = true)
	private List<Segment> segment;

	public CodeOuTexte() {
	}

	public List<Segment> getSegment() {
		return segment;
	}

	public void setSegment(List<Segment> segment) {
		this.segment = segment;
	}
}