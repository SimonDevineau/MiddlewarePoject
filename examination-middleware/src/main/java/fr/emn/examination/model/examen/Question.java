package fr.emn.examination.model.examen;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

public class Question {
	public Question(String consigne, CodeOuTexte codeOuTexte,
			Caseacocher caseacocher, ChoixMultiples choixMultiples,
			Protocole protocole, BigInteger id, String title) {
		super();
		this.consigne = consigne;
		this.codeOuTexte = codeOuTexte;
		this.caseacocher = caseacocher;
		this.choixMultiples = choixMultiples;
		this.protocole = protocole;
		this.id = id;
		this.title = title;
	}

	@XmlElement(required = true)
	private String consigne;
	private CodeOuTexte codeOuTexte;
	private Caseacocher caseacocher;
	private ChoixMultiples choixMultiples;
	@XmlElement(required = true)
	private Protocole protocole;
	@XmlSchemaType(name = "positiveInteger")
	@XmlAttribute(required = true)
	private BigInteger id;
	@XmlAttribute
	private String title;

	public Question() {
	}

	public String getConsigne() {
		return consigne;
	}

	public void setConsigne(String consigne) {
		this.consigne = consigne;
	}

	public CodeOuTexte getCodeOuTexte() {
		return codeOuTexte;
	}

	public void setCodeOuTexte(CodeOuTexte codeOuTexte) {
		this.codeOuTexte = codeOuTexte;
	}

	public Caseacocher getCaseacocher() {
		return caseacocher;
	}

	public void setCaseacocher(Caseacocher caseacocher) {
		this.caseacocher = caseacocher;
	}

	public ChoixMultiples getChoixMultiples() {
		return choixMultiples;
	}

	public void setChoixMultiples(ChoixMultiples choixMultiples) {
		this.choixMultiples = choixMultiples;
	}

	public Protocole getProtocole() {
		return protocole;
	}

	public void setProtocole(Protocole protocole) {
		this.protocole = protocole;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}