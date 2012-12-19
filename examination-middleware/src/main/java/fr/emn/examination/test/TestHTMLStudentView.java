package fr.emn.examination.test;


import fr.emn.examination.model.examen.Examen;

import fr.emn.examination.parser.ExamenParser;
import fr.emn.examination.persistence.Factory;
import fr.emn.examination.persistence.GenericDAO;
import fr.emn.examination.view.HTMLGenerator;
  
public class TestHTMLStudentView {

	public static void main(String[] args) {
		String pathFile = "src/main/resources/examenExample.xml";
		ExamenParser parser = new ExamenParser(); 
		Examen mockExam = parser.get(pathFile);
		HTMLGenerator htmlView = new HTMLGenerator(mockExam);
		//System.out.println(htmlView.examenToHTML());
		GenericDAO<Examen> examenDao = Factory.getExamenDAO();
		examenDao.create(mockExam);
		System.out.println(""+examenDao.retrieveAll().size());
	}
}