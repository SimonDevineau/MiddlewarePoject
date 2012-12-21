package fr.emn.examination.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.emn.examination.model.examen.Examen;

public class ExamenStudent extends Examen implements Serializable {

    /**
     * 
     */
    private static final long     serialVersionUID = -9028021056535405200L;
    private List<ExerciceStudent> exos;

    public ExamenStudent() {
    }

    public ExamenStudent(Examen exam, JavaCode javaCode) {
	this.exos = new ArrayList<ExerciceStudent>();
	for (fr.emn.examination.model.examen.Examen.Enonce.Exercice exo : exam
	        .getEnonce().getExercice()) {
	    this.exos.add(new ExerciceStudent(exo, javaCode));
	}
    }

    public List<ExerciceStudent> getExos() {
	return exos;
    }

    public void setExos(List<ExerciceStudent> exos) {
	this.exos = exos;
    }

}
