package fr.emn.examination.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;

public class ExamenStudent extends Examen implements Serializable {

    /**
     * 
     */
    private static final long     serialVersionUID = -9028021056535405200L;
    private List<ExerciceStudent> exos;
    private Map<String, Question> questionsMap;

    public ExamenStudent() {
    }

    public ExamenStudent(Examen exam) {
	super(exam.getInformation(), exam.getPreambule(), exam
	        .getIntroduction(), exam.getEnonce(), exam.getConclusion(),
	        exam.getId());
	this.exos = new ArrayList<ExerciceStudent>();
	this.questionsMap = new HashMap<String, Examen.Enonce.Exercice.Question>();
	for (fr.emn.examination.model.examen.Examen.Enonce.Exercice exo : exam
	        .getEnonce().getExercice()) {
	    for (Question q : exo.getQuestion()) {
		questionsMap.put(q.getId(), q);
	    }
	}
    }

    public void setJavaCode(JavaCode javaCode) {
	for (fr.emn.examination.model.examen.Examen.Enonce.Exercice exo : this
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

    public Map<String, Question> getQuestionsMap() {
	return questionsMap;
    }

    public void setQuestionsMap(Map<String, Question> questionsMap) {
	this.questionsMap = questionsMap;
    }

}
