package fr.emn.examination.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emn.examination.model.examen.Examen;


public class ExamenStudent {

	private Examen exam;
	
	private List<Exercice> exos;

	public ExamenStudent() {
	}

	public ExamenStudent(Examen exam,JavaCode javaCode) {
		this.exam = exam;
		this.exos = new ArrayList<Exercice>();
		for (fr.emn.examination.model.examen.Examen.Enonce.Exercice exo : exam.getEnonce().getExercice()) {
			this.exos.add(new Exercice(exo, javaCode));
		}
	}

	public Examen getExam() {
		return exam;
	}

	public void setExam(Examen exam) {
		this.exam = exam;
	}

	public List<Exercice> getExos() {
		return exos;
	}

	public void setExos(List<Exercice> exos) {
		this.exos = exos;
	}

}
