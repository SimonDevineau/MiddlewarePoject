package fr.emn.examination.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.ChoixMultiples.Choix;

public class ChoixMultipleQuestion extends QuestionStudent {

    private ChoixMultiples     choix;
    private List<Choix>        selectedCases;
    private Map<String, Choix> displayedCases;

    public ChoixMultipleQuestion() {
    }

    public ChoixMultipleQuestion(Question q, ChoixMultiples choix) {
	super(q);
	this.choix = choix;
	this.selectedCases = new ArrayList<Choix>();
	this.displayedCases = new HashMap<String, Choix>();
	for (Choix c : choix.getChoix()) {
	    displayedCases.put(c.getValue(), c);
	}
    }

    public ChoixMultiples getChoix() {
	return choix;
    }

    public void setChoix(ChoixMultiples choix) {
	this.choix = choix;
    }

    public List<Choix> getSelectedCases() {
	return selectedCases;
    }

    public void setSelectedCases(List<Choix> selectedCases) {
	this.selectedCases = selectedCases;
    }

    public Map<String, Choix> getDisplayedCases() {
	return displayedCases;
    }

    public void setDisplayedCases(Map<String, Choix> displayedCases) {
	this.displayedCases = displayedCases;
    }

    @Override
    public double evaluer() {
	// TODO Auto-generated method stub
	return 0;
    }

}
