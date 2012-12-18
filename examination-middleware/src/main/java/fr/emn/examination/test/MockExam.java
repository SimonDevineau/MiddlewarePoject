package fr.emn.examination.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import fr.emn.examination.model.examen.Case;
import fr.emn.examination.model.examen.Caseacocher;
import fr.emn.examination.model.examen.ChoixMultiples;
import fr.emn.examination.model.examen.CodeOuTexte;
import fr.emn.examination.model.examen.Destination;
import fr.emn.examination.model.examen.EnTete;
import fr.emn.examination.model.examen.Enonce;
import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.model.examen.Exercice;
import fr.emn.examination.model.examen.Information;
import fr.emn.examination.model.examen.Protocole;
import fr.emn.examination.model.examen.Question;

public class MockExam {

	public Examen createMockExam() {
		// Creation of enTete
		String titre = "titre";
		String objet = "objet";
		String date = "date";
		String auteur = "auteur";
		String source = "source";
		EnTete enTete = new EnTete(titre, objet, date, auteur, source);

		// Creation of the destination
		String uv = "uv";
		String module = "module";
		String coefficient = "coefficient";
		Destination destination = new Destination(uv, module, coefficient);

		// Creation of the version
		Information information = new fr.emn.examination.model.examen.Information(
				enTete, destination, "version", "commentaires");

		// Creation of the exercices

		String title = "titre question1";
		BigInteger id = new BigInteger("10");
		String langage = "francais";
		String introduction = "introduction question";

		BigInteger coeff = new BigInteger("30");
		Exercice exo1 = new Exercice(introduction, createQuestions(), title,
				id, langage, coeff);

		List<Exercice> exercices = new ArrayList<Exercice>();
		exercices.add(exo1);
		Enonce enonce = new Enonce(exercices);

		Examen mockExam = new fr.emn.examination.model.examen.Examen(
				information, "preambule", "introduction", enonce, "conclusion");
		return mockExam;

	}

	private Caseacocher createCaseACaseacocher() {
		String value1 = "value1";
		BigInteger id1 = new BigInteger("1");
		boolean correction1 = true;
		Case case1 = new Case(value1, id1, correction1);

		String value2 = "value2";
		BigInteger id2 = new BigInteger("2");
		boolean correction2 = true;
		Case case2 = new Case(value2, id2, correction2);

		List<Case> _case = new ArrayList<Case>();
		_case.add(case1);
		_case.add(case2);
		return new Caseacocher(_case);

	}

	private List<Question> createQuestions() {
		BigInteger id = new BigInteger("20");
		String consigne = "consigne Q1";
		String titleQ1 = "titre q1";
		CodeOuTexte codeOuTexte;
		Caseacocher caseacocher;
		Protocole protocole = new Protocole("value", "3 essais", "1.0",
				"20 min", "18 points");
		Question q1 = new Question(consigne, null, createCaseACaseacocher(),
				null, protocole, id, titleQ1);

		List<Question> questions = new ArrayList<Question>();
		questions.add(q1);
		return questions;
	}
}
