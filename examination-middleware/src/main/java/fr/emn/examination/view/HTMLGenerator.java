package fr.emn.examination.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		String corpsPage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
				+ "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" \n"
				+ "xmlns:h=\"http://java.sun.com/jsf/html\" \n"
				+ "xmlns:f=\"http://java.sun.com/jsf/core\" \n"
				+ "xmlns:ui=\"http://java.sun.com/jsf/facelets\" \n"
				+ "xmlns:p=\"http://primefaces.org/ui\"> \n"
				+ "<h:head></h:head><body> \n";
		
		corpsPage += enteteToHTML(exam.getInformation().getEnTete());
		corpsPage += enonceToHTML(exam.getEnonce());
		corpsPage += "</body>\n</html> \n";
		try {
			FileWriter enonce = new FileWriter("src/main/webapp/htmlGenerated.xhtml", false);
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
				"<h3>Titre: %s</h3>\n<h4>Objet: %s</h4>\n<h5>Date: %s</h5>\n<p>Auteur: %s</p>\n<p>Source: %s</p>\n",
				et.getTitre(), et.getObjet(), et.getDate(), et.getAuteur(),
				et.getSource());

		return html;
	}

	public String destinationToHTML(Destination d) {
		String html = "";
		html += String
				.format("<p><b>UV:</b>%s</p>\n<p><b>Module:</b>%s</p>\n<p><b>Coefficient:</b>%s</p>\n",
						d.getUv(), d.getModule(), d.getCoefficient());
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
				"<input type=\"radio\" name=\"middleware\" id=\"%d\" value=\"%s\"> %s</input><br/>\n",
				c.getId(), c.getValue(), c.getValue());
		return html;
	}

	public String caseacocherToHTML(Caseacocher c) {
		String html = "";
		html += "<form name=\"formulaire\" action=\"http://www.mydomain.com/myformhandler.cgi\""
				+ " method=\"POST\">\n<div align=\"center\"><br/>\n";
		for (Case ca : c.get_case()) {
			html += caseToHTML(ca);
		}
		html += "</div>\n</form>\n";
		return html;
	}

	// TODO
	public String questionToHTML(Question q) {
		String html = String.format("<p:tab title=\"%s\">\n"  
        +"<h:panelGrid columns=\"2\" cellpadding=\"10\">\n"  
        +"<h:outputText>",q.getTitle());
		html+=q.getConsigne();
		html+="</h:outputText>\n";
		html+=caseacocherToHTML(q.getCaseacocher());
		html+="</h:panelGrid>\n  </p:tab>\n  ";
		return html;
	}

	// TODO
	public String exerciceToHTML(List<Exercice> list) {
		String html = "<p:accordionPanel multiple= \"true\">\n";
		for(Exercice e : list)
			for(Question q : e.getQuestion())
				html+= questionToHTML(q)+"\n";
		return html + "</p:accordionPanel>\n";
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
