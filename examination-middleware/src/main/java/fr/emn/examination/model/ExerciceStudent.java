package fr.emn.examination.model;

import java.io.Serializable;
import java.util.Map;

public class ExerciceStudent extends
        fr.emn.examination.model.examen.Examen.Enonce.Exercice implements
        Serializable {
    /**
     * 
     */
    private static final long                                     serialVersionUID = -5412110589629756311L;
    private Map<String, fr.emn.examination.model.QuestionStudent> questionsMap;

    public ExerciceStudent() {
    }

    public ExerciceStudent(
	    fr.emn.examination.model.examen.Examen.Enonce.Exercice exercice,
	    JavaCode javaCode) {
	for (fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question q : this
	        .getQuestion()) {
	    if (q.getCaseacocher() != null) {
		this.questionsMap.put(q.getId() + "",
		        new CaseACocherQuestion(q.getCaseacocher()));
	    }
	    if (q.getChoixMultiples() != null) {
		this.questionsMap.put(q.getId() + "",
		        new ChoixMultipleQuestion(q.getChoixMultiples()));
	    }
	    if (q.getCodeOuTexte() != null) {
		this.questionsMap.put(q.getId() + "", javaCode.getQuestions()
		        .get(q.getId()));
	    }
	}
    }

    public Map<String, fr.emn.examination.model.QuestionStudent> getQuestionsMap() {
	return questionsMap;
    }

    public void setQuestionsMap(
	    Map<String, fr.emn.examination.model.QuestionStudent> questionsMap) {
	this.questionsMap = questionsMap;
    }
}
