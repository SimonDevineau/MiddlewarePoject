package fr.emn.examination.model;

import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;

public abstract class QuestionStudent extends Question {

	public QuestionStudent() {
	}

	public QuestionStudent(Question q) {
		super(q.getConsigne(), q.getCodeOuTexte(), q.getCaseacocher(), q
				.getChoixMultiples(), q.getProtocole(), q.getId(), q.getTitle());
	}

	public abstract double evaluer();

	public boolean isCaseACocher(QuestionStudent q) {
		return q instanceof CaseACocherQuestion;
	}

	public boolean isCodeOuTexte(QuestionStudent q) {
		return q instanceof CodeQuestion;
	}

	public boolean isChoixMultiples(QuestionStudent q) {
		return q instanceof ChoixMultipleQuestion;
	}

}
