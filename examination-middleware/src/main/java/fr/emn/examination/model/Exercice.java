package fr.emn.examination.model;

import java.util.List;
import java.util.Map;

public class Exercice {
    private List<fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question> bareQuestions;
    private Map<String, Question>                                                 questions;

    public Exercice() {
    }

    public Exercice(
	    fr.emn.examination.model.examen.Examen.Enonce.Exercice exercice,
	    JavaCode javaCode) {
	setBareQuestions(exercice.getQuestion());
	for (fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question q : exercice
	        .getQuestion()) {
	    if (q.getCaseacocher() != null) {
		this.questions.put(q.getId() + "",
		        new CaseACocherQuestion(q.getCaseacocher()));
	    }
	    if (q.getChoixMultiples() != null) {
		this.questions.put(q.getId() + "",
		        new ChoixMultipleQuestion(q.getChoixMultiples()));
	    }
	    if (q.getCodeOuTexte() != null) {
		this.questions.put(q.getId() + "",
		        javaCode.getQuestions().get(q.getId()));
	    }
	}
    }

    public List<fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question> getBareQuestions() {
	return bareQuestions;
    }

    public void setBareQuestions(
	    List<fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question> bareQuestions) {
	this.bareQuestions = bareQuestions;
    }

    public Map<String, Question> getQuestions() {
	return questions;
    }

    public void setQuestions(Map<String, Question> questions) {
	this.questions = questions;
    }
}
