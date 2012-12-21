package fr.emn.examination.model;

import java.util.Map;

public class Exercice {
	private Map<String, Question> questions;
	
	public Exercice() {
	}
	
	public Exercice(fr.emn.examination.model.examen.Examen.Enonce.Exercice exercice,JavaCode javaCode) {
		for (fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question q : exercice
				.getQuestion()) {
			if(q.getCaseacocher()!=null) {
				this.questions.put(q.getId()+"",new CaseACocherQuestion(q.getCaseacocher()));
			}if(q.getChoixMultiples()!=null) {
				this.questions.put(q.getId()+"",new ChoixMultipleQuestion(q.getChoixMultiples()));
			}if(q.getCodeOuTexte()!=null) {
				this.questions.put(q.getId()+"",javaCode.getQuestions().get(q.getId()));
			}
		}
	}
}
