package fr.emn.examination.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import fr.emn.examination.persistence.GenericDAO;

public class MockXMLStorageDAO implements GenericDAO<String> {

	private ArrayList<String> inMemoryDB;

	public MockXMLStorageDAO() {
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

	private static final String fichier = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <examen xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" 	xsi:noNamespaceSchemaLocation=\"xmlSchemaExamen.xsd\" id=\"idBDD\"> 	<information> 		<enTete> 			<titre>Examen de test pour le middleware</titre> 			<objet>Cet examen est un test pour le Middleware</objet> 			<date>19 décembre 2012</date> 			<auteur>L'equipe GSI</auteur> 			<source>Test.java</source> 		</enTete> 	</information> 	<enonce> 		<exercice langage=\"\" id=\"e1\" title=\"Un Module de calcul\"> 			<introduction>Dans un module de calculs, appelé Calculs, 			on développe des fonctions génériques de calculs opérant sur les interfaces précédentes. 			</introduction> 			<question id=\"q1\"> 				<consigne>Test de code</consigne> 				<codeOuTexte> 					<segment id=\"s1\"> 						<typeCorrection>syntaxeSeulement</typeCorrection> 						<correction>correction1</correction> 					</segment> 					<segment id=\"s2\"> 						<typeCorrection>testCompilationPuisExecution</typeCorrection> 						<correction>correction2</correction> 					</segment> 				</codeOuTexte> 				<protocole nbPoints=\"4\"></protocole> 			</question> 			<question id=\"q2\"> 				<consigne>Cocher les visibilités existantes en Java</consigne> 				<caseacocher> 					<case correction=\"true\" id=\"c2\">Public</case> 					<case correction=\"true\" id=\"c1\">Private</case> 					<case correction=\"true\" id=\"c3\">Protected</case> 					<case correction=\"true\" id=\"c4\">Package</case> 					<case correction=\"false\" id=\"c5\">Intime</case> 				</caseacocher> 				<protocole nbPoints=\"2\"></protocole> 			</question> 		</exercice> 		<exercice langage=\"Java\" title=\"2\" id=\"Exercice 2\"> 			<introduction>Introduction de l'exo 2</introduction> 			<question id=\"q1\"> 				<consigne>L'héritage mutiple éxiste-t-il en Java?</consigne> 				<choixMultiples> 					<choix id=\"c1\">Oui</choix> 					<choix id=\"c2\">Non</choix> 					<correction>c1</correction> 				</choixMultiples> 				<protocole nbPoints=\"2\"></protocole> 			</question> 		</exercice> 	</enonce> </examen> ";

}
