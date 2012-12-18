package fr.emn.examination.view;

import java.util.List;

import fr.emn.examination.model.examen.Case;
import fr.emn.examination.model.examen.Caseacocher;
import fr.emn.examination.model.examen.Destination;
import fr.emn.examination.model.examen.EnTete;
import fr.emn.examination.model.examen.Enonce;
import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.model.examen.Exercice;
import fr.emn.examination.model.examen.Information;
import fr.emn.examination.model.examen.Question;
import fr.emn.examination.test.MockExam;

public class HTMLGenerator {

	private Examen exam;

	public HTMLGenerator(Examen exam) {
		this.exam = exam;
	}

	public String examenToHTML() {
		String corpsPage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\""
				+ "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\""
				+ "xmlns:h=\"http://java.sun.com/jsf/html\""
				+ "xmlns:f=\"http://java.sun.com/jsf/core\""
				+ "xmlns:ui=\"http://java.sun.com/jsf/facelets\""
				+ "xmlns:p=\"http://primefaces.org/ui\">"
				+ "<h:head></h:head><body>";
		corpsPage += enonceToHTML(exam.getEnonce());
		corpsPage += enteteToHTML(exam.getInformation().getEnTete());
		corpsPage += "</body></html>";
		return (corpsPage);
	}

	/*
	 * Partie Informations relatives à l'examen
	 */

	public String enteteToHTML(EnTete et) {
		// titre, objet, date, auteur, source
		String html = "";
		html += String.format(
				"<h3>%s</h3><h4>%s</h4><h5>%s</h5><h>%s</h><h>%s</h>",
				et.getTitre(), et.getObjet(), et.getDate(), et.getAuteur(),
				et.getSource());

		return html;
	}

	public String destinationToHTML(Destination d) {
		String html = "";
		html += String
				.format("<p><b>UV:</b>%s</p><p><b>Module:</b>%s</p><p><b>Coefficient:</b>%s</p>",
						d.getUv(), d.getModule(), d.getCoefficient());
		return html;
	}

	public String InformationToHTML(Information inf) {
		String html = "";
		html += destinationToHTML(inf.getDestination());
		html += String
				.format("<p><b>Version de l'examen:</b>%s</p><p><b>Commentaires:</b>%s</p>",
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
				"<input type=\"radio\" id=\"%d\" value=\"%s\"> %s<br>",
				c.getId(), c.getValue(), c.getValue());
		return html;
	}

	public String caseacocherToHTML(Caseacocher c) {
		String html = "";
		html += "<form name=\"formulaire\" action=\"http://www.mydomain.com/myformhandler.cgi"
				+ " method=\"POST\"><div align=\"center\"><br>";
		for (Case ca : c.get_case()) {
			html += caseToHTML(ca);
		}
		html += "</div></form>";
		return html;
	}

	// TODO
	public String questionToHTML(Question q) {

		return caseacocherToHTML(q.getCaseacocher());
	}

	// TODO
	public String exerciceToHTML(List<Exercice> list) {

		return questionToHTML(list.get(0).getQuestion().get(0));
	}

	// TODO
	public String enonceToHTML(Enonce e) {

		return exerciceToHTML(e.getExercice());
	}

	
	public static void main(String[] args) {
		MockExam mock = new MockExam();
		System.out.println(new HTMLGenerator(mock.createMockExam()).examenToHTML());
	}
}
