package fr.emn.examination.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.ChoixMultiples;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.ChoixMultiples.Choix;

public class ChoixMultipleQuestion extends Question {

	private ChoixMultiples choix;
	private List<Choix> aRetourner;
	private Map<String, String> aAfficher;

	public ChoixMultipleQuestion() {
	}

	public ChoixMultipleQuestion(ChoixMultiples choix) {
		this.choix = choix;
		this.aRetourner = new ArrayList<Choix>();
		this.aAfficher = new HashMap<String, String>();
		for (Choix c : choix.getChoix()) {
			aAfficher.put(c.getId() + "", c.getValue());
		}
	}

	public ChoixMultiples getChoix() {
		return choix;
	}

	public void setChoix(ChoixMultiples choix) {
		this.choix = choix;
	}

	public List<Choix> getaRetourner() {
		return aRetourner;
	}

	public void setaRetourner(List<Choix> aRetourner) {
		this.aRetourner = aRetourner;
	}

	public Map<String, String> getaAfficher() {
		return aAfficher;
	}

	public void setaAfficher(Map<String, String> aAfficher) {
		this.aAfficher = aAfficher;
	}

	@Override
	public double evaluer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
