package fr.emn.examination.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.Caseacocher;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.Caseacocher.Case;

public class CaseACocherQuestion extends Question {

	private Caseacocher cases;
	private List<Case> aRetourner;
	private Map<String, String> aAfficher;

	public CaseACocherQuestion() {
	}

	public CaseACocherQuestion(Caseacocher cases) {
		this.cases = cases;
		this.aRetourner = new ArrayList<Case>();
		this.aAfficher = new HashMap<String, String>();
		for (Case c : cases.getCase()) {
			aAfficher.put(c.getId() + "", c.getValue());
		}
	}

	public Caseacocher getCases() {
		return cases;
	}

	public void setCases(Caseacocher cases) {
		this.cases = cases;
	}

	public List<Case> getaRetourner() {
		return aRetourner;
	}

	public void setaRetourner(List<Case> aRetourner) {
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
