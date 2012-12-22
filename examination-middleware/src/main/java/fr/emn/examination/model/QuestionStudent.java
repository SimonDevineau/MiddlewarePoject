package fr.emn.examination.model;

import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;

public abstract class QuestionStudent extends Question {

    public QuestionStudent() {
    }

    public QuestionStudent(Question q) {
	super(q.getConsigne(), q.getCodeOuTexte(), q.getCaseacocher(), q
	        .getChoixMultiples(), q.getProtocole(), q.getId(), q.getTitle());
    }

    public abstract double evaluer();

}
