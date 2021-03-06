package fr.emn.examination.parser;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import fr.emn.examination.model.examen.Examen;

public class ExamenParser {

    private Unmarshaller parser;

    public ExamenParser() {
	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(Examen.class);
	    this.parser = jaxbContext.createUnmarshaller();

	}
	catch (JAXBException e) {
	    e.printStackTrace();
	    System.out.println("Context Failed to load");
	}
    }

    public Examen getFromFile(String pathFile) {
	File fileToParse = new File(pathFile);
	if (fileToParse.exists()) {

	    try {
		fileToParse.createNewFile();
		System.out.println(fileToParse.toString());
		return (Examen) this.parser.unmarshal(fileToParse);
	    }
	    catch (JAXBException e) {
		e.printStackTrace();
		System.out.println("Parser failed to identify " + pathFile
		        + " as a valide response");
		return new Examen();
	    }
	    catch (IOException e) {
		System.out.println("Parser failed to get the file : "
		        + pathFile);
		e.printStackTrace();
		return new Examen();
	    }
	}
	else {
	    // TODO
	    System.out
		    .println("The file: "
		            + pathFile
		            + " does not exist. Attention le chemin est absolu et specifie dans le fichier User");
	    return new Examen();
	}

    }

    public Examen getFromString(String content) throws JAXBException {
	return (Examen) this.parser.unmarshal(new StringReader(content));
    }
}
