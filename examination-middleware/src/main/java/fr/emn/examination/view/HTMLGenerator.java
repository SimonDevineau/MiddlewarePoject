package fr.emn.examination.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.model.examen.Examen.Enonce;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.Caseacocher;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.Caseacocher.Case;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.ChoixMultiples;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.CodeOuTexte;
import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question.CodeOuTexte.Segment;
import fr.emn.examination.model.examen.Examen.Information;
import fr.emn.examination.model.examen.Examen.Information.Destination;
import fr.emn.examination.model.examen.Examen.Information.EnTete;
import fr.emn.examination.persistence.Factory;
import fr.emn.examination.util.Utils;

public class HTMLGenerator {

	private Examen exam;

	public HTMLGenerator(String key) {
		//FIXME: sale pour le moment, juste pour les tests
		this.exam = Factory.getExamenDAO().retrieveByKey("Dans un module de calculs, appelé Calculs,"
			+"on développe des fonctions génériques de calculs opérant sur les interfaces précédentes.");
	}

	public String examenToHTML() {
		String corpsPage = Utils.loadFile(this.getClass()
				.getResource("fragments/header.html").getFile());

		corpsPage += enteteToHTML(exam.getInformation().getEnTete());
		corpsPage += enonceToHTML(exam.getEnonce());
		corpsPage += Utils.loadFile(this.getClass()
				.getResource("fragments/enFile.html").getFile());
		try {
			FileWriter enonce = new FileWriter(
					"src/main/webapp/htmlGenerated.xhtml", false);
			enonce.write(corpsPage);
			enonce.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (corpsPage);
	}

	/*
	 * Partie Informations relatives à l'examen
	 */

	public String enteteToHTML(EnTete et) {
		// titre, objet, date, auteur, source
		String html = "";
		html += String.format(
				this.getClass().getResource("fragments/header.html").getFile(),
				et.getTitre(), et.getObjet(), et.getDate(), et.getAuteur(),
				et.getSource());

		return html;
	}

	public String destinationToHTML(Destination d) {
		String html = "";
		html += String
				.format("<p><b>UV:</b>%s</p>\n<p><b>Module:</b>%s</p>\n<p><b>Coefficient:</b>%s</p>\n",
						d.getUV(), d.getModule(), d.getCoefficient());
		return html;
	}

	public String informationToHTML(Information inf) {
		String html = "";
		html += destinationToHTML(inf.getDestination());
		html += String
				.format("<p><b>Version de l'examen:</b>%s</p>\n<p><b>Commentaires:</b>%s</p>\n",
						inf.getVersion(), inf.getCommentaires());
		html += enteteToHTML(inf.getEnTete());
		return html;
	}

	/*
	 * Partie examen en lui-même
	 */
	public String caseToHTML(Case c) {
		String html = "";
		html += String.format(
				Utils.loadFile(this.getClass()
						.getResource("fragments/case.html").getFile()),
				c.getId(), c.getValue(), c.getValue());
		return html;
	}

	public String caseacocherToHTML(Caseacocher c) {
		String html = "";
		if (c != null && c.getCase() != null) {
			html += Utils.loadFile(this.getClass()
					.getResource("fragments/caseACocher.html").getFile());
			for (Case ca : c.getCase()) {
				html += caseToHTML(ca);
			}

			html += Utils.loadFile(this.getClass()
					.getResource("fragments/submit.html").getFile());
		}
		return html;
	}

	// TODO
	public String questionToHTML(Question q, String qNumber) {
		String html = "";
		if (q != null) {
			html = String.format(
					Utils.loadFile(this.getClass()
							.getResource("fragments/question.html").getFile()),
					qNumber);
			html += q.getConsigne()+"<br />";

			if (q.getCaseacocher() != null) {
				html += caseacocherToHTML(q.getCaseacocher());
			} else if (q.getChoixMultiples() != null) {
				html += choixMultiplesToHTML(q.getChoixMultiples());
			} else if (q.getCodeOuTexte() != null) {
				html += codeOuTexteToHTML(q.getCodeOuTexte());
			}
			html += "</h:panelGrid>\n  </p:tab>\n  ";
		}
		return html;
	}

	// TODO
	public String exerciceToHTML(List<Exercice> list) {
		String html = "<p:accordionPanel multiple= \"true\">\n";
		String qNumber = "";
		for (int indexExo = 0; indexExo < list.size(); indexExo++) {
			for (int i = 0; i < list.get(indexExo).getQuestion().size(); i++) {
				qNumber = "Question " + (indexExo + 1) + "." + (i + 1);
				html += questionToHTML(list.get(indexExo).getQuestion().get(i),
						qNumber) + "\n";
			}
		}
		return html + "</p:accordionPanel>\n";
	}

	// TODO
	public String enonceToHTML(Enonce e) {
		if (e != null) {
			return exerciceToHTML(e.getExercice());
		} else {
			return "There is an error with the exam";
		}
	}

	public String preambuleToHTML() {
		String html = "";
		if (exam.getPreambule() != null) {

		}
		return html;
	}

	public String introductionToHTML() {
		String html = "";
		if (exam.getIntroduction() != null) {

		}
		return html;
	}

	public String conclusionToHTML() {
		String html = "";
		return html;
	}

	public String versionToHTML() {
		String html = "";
		if (exam.getInformation().getVersion() != null) {

		}
		return html;
	}

	public String commentairesToHTML() {
		String html = "";
		if (exam.getInformation().getCommentaires() != null) {

		}
		return html;
	}

	public String codeOuTexteToHTML(CodeOuTexte codeOuTexte) {
		String html = "";
		if (codeOuTexte != null && codeOuTexte.getSegment() != null) {
			for (Segment s : codeOuTexte.getSegment()) {
				html += segmentToHTML(s);
			}
		}
		return html;
	}

	public String choixMultiplesToHTML(ChoixMultiples choixMultiples) {
		String html = "";
		if (choixMultiples != null && choixMultiples.getChoix() != null) {

		}
		return html;
	}

	public String segmentToHTML(Segment s) {
		String html = "";
		if (s != null) {
			html += Utils.loadFile(this.getClass()
					.getResource("fragments/segment.html").getFile());
		}
		return html;
	}

	public String choixToHTML() {
		String html = "";
		return html;
	}
}
