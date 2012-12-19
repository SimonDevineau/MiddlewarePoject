package fr.emn.examination.test;


import fr.emn.examination.model.examen.Examen;

import fr.emn.examination.parser.ExamenParser;
  
public class TestHTMLStudentView {

	public static void main(String[] args) {
		String pathFile = "src/main/resources/examenExample.xml";
		ExamenParser parser = new ExamenParser(); 
		Examen mockExam = parser.get(pathFile);
	}
}