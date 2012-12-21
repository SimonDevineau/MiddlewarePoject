package fr.emn.examination.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import fr.emn.examination.persistence.GenericDAO;

public class MockStoredFile implements GenericDAO<String> {

    private ArrayList<String> inMemoryDB;

    public MockStoredFile() {
	inMemoryDB = new ArrayList<String>();
	inMemoryDB.add(fichier);
    }

    public ArrayList<String> getInMemoryDB() {
	return inMemoryDB;
    }

    public void setInMemoryDB(ArrayList<String> inMemoryDB) {
	this.inMemoryDB = inMemoryDB;
    }

    @Override
    public void create(String t) {
	this.inMemoryDB.add(t);
	System.out.println(this.inMemoryDB.indexOf(t));
    }

    @Override
    public void remove(String key) {
	this.inMemoryDB.remove(key);
    }

    @Override
    public List<String> retrieveAll() {
	return this.inMemoryDB;
    }

    @Override
    public String retrieveByKey(String key) {
	return this.inMemoryDB.get(0);
    }

    @Override
    public void update(String key, String updated) {
	this.inMemoryDB.set(0, updated);
    }

    private static final String fichier = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <examen xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" 	xsi:noNamespaceSchemaLocation=\"xmlSchemaExamen.xsd\" id=\"idBDD\"> 	<information> 		<enTete> 			<titre>titre</titre> 			<objet>Cet examen est un test pour le Middleware</objet> 			<date>19 dÃ©cembre 2012</date> 			<auteur>L'equipe GSI</auteur> 			<source>Test.java</source> 		</enTete> 	</information> 	<enonce> 		<exercice langage=\"\" id=\"1\" title=\"Un Module de calcul\"> 			<introduction>Dans un module de calculs, appelÃ© Calculs, 			on dÃ©veloppe des fonctions gÃ©nÃ©riques de calculs opÃ©rant sur les interfaces prÃ©cÃ©dentes. 			</introduction>  			<question id=\"1\"> 				<consigne>Quel est le meilleur dÃ©partement?</consigne> 				<caseacocher> 					<case correction=\"true\" id=\"2\">Loire-Atlantique</case> 					<case correction=\"true\" id=\"1\">VendÃ©e</case> 				</caseacocher> 				<protocole nbPoints=\"2\"></protocole> 			</question> 		</exercice> 		<exercice langage=\"Java\" id=\"2\"> 			<introduction>Introduction de l'expo 2</introduction> 			<question id=\"1\"> 				<consigne>Quel est le meilleur dÃ©partement?</consigne> 				<caseacocher> 					<case correction=\"true\" id=\"2\">Loire-Atlantique</case> 					<case correction=\"true\" id=\"1\">VendÃ©e</case> 				</caseacocher> 				<protocole nbPoints=\"2\"></protocole> 			</question> 		</exercice> 		<exercice langage=\"Java\" id=\"3\"> 			<question id=\"1\"> 				<consigne>Test de code</consigne> 				<codeOuTexte> 					<segment id=\"1\"> 						<typeCorrection>syntaxeSeulement</typeCorrection> 						<correction>correction1</correction> 					</segment> 					<segment id=\"2\"> 						<typeCorrection>testCompilationPuisExecution</typeCorrection> 						<correction>correction2</correction> 					</segment>  				</codeOuTexte> 				<protocole nbPoints=\"4\"></protocole> 			</question> 		</exercice> 	</enonce> </examen> ";

}
