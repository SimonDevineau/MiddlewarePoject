package fr.emn.examination.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.Caseacocher.Case;

public class CaseACocherQuestion extends QuestionStudent {

    private Caseacocher       cases;
    private List<Case>        selectedCases;
    private Map<String, Case> displayedCases;

    public CaseACocherQuestion() {
    }

    public CaseACocherQuestion(Question q, Caseacocher cases) {
	super(q);
	this.cases = cases;
	this.setSelectedCases(new ArrayList<Case>());
	this.displayedCases = new HashMap<String, Case>();
	for (Case c : cases.getCase()) {
	    displayedCases.put(c.getValue(), c);
	}
    }

    public Caseacocher getCases() {
	return cases;
    }

    public void setCases(Caseacocher cases) {
	this.cases = cases;
    }

    public List<Case> getSelectedCases() {
	return selectedCases;
    }

    public void setSelectedCases(List<Case> selectedCases) {
	this.selectedCases = selectedCases;
    }

    public Map<String, Case> getDisplayedCases() {
	return displayedCases;
    }

    public void setDisplayedCases(Map<String, Case> displayedCases) {
	this.displayedCases = displayedCases;
    }

    @Override
    public double evaluer() {
	// TODO Auto-generated method stub
	return 0;
    }

}
