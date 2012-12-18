package fr.emn.examination.model.examen;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

public class Exercice {
	public Exercice(String introduction, List<Question> question, String title,
			BigInteger id, String langage, BigInteger coefficient) {
		super();
		this.introduction = introduction;
		this.question = question;
		this.title = title;
		this.id = id;
		this.langage = langage;
		this.coefficient = coefficient;
	}

	private String introduction;
	@XmlElement(required = true)
	private List<Question> question;
	@XmlAttribute
	private String title;
	@XmlSchemaType(name = "positiveInteger")
	@XmlAttribute(required = true)
	private BigInteger id;
	@XmlAttribute(required = true)
	private String langage;
	@XmlSchemaType(name = "positiveInteger")
	@XmlAttribute
	private BigInteger coefficient;

	public Exercice() {
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getLangage() {
		return langage;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}

	public BigInteger getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(BigInteger coefficient) {
		this.coefficient = coefficient;
	}
}