package fr.emn.examination.model.examen;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Enonce {
	public Enonce(List<Exercice> exercice) {
		super();
		this.exercice = exercice;
	}

	@XmlElement(required = true)
	private List<Exercice> exercice;

	public Enonce() {
	}

	public List<Exercice> getExercice() {
		return exercice;
	}

	public void setExercice(List<Exercice> exercice) {
		this.exercice = exercice;
	}
}