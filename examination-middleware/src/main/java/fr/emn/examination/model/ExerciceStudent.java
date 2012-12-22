package fr.emn.examination.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExerciceStudent extends
        fr.emn.examination.model.examen.Examen.Enonce.Exercice implements
        Serializable {
    /**
     * 
     */
    private static final long                              serialVersionUID = -5412110589629756311L;
    private List<fr.emn.examination.model.QuestionStudent> questions;

    public ExerciceStudent() {
    }

    public ExerciceStudent(
	    fr.emn.examination.model.examen.Examen.Enonce.Exercice exercice,
	    JavaCode javaCode) {
	questions = new ArrayList<QuestionStudent>();
	for (fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question q : this
	        .getQuestion()) {
	    if (q.getCaseacocher() != null) {
		questions.add(new CaseACocherQuestion(q.getCaseacocher()));
	    }
	    if (q.getChoixMultiples() != null) {
		questions.add(new ChoixMultipleQuestion(q.getChoixMultiples()));
	    }
	    if (q.getCodeOuTexte() != null) {
		questions.add(javaCode.getQuestions().get(q.getId()));
	    }
	}
    }
}
