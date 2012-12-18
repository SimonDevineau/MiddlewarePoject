package fr.emn.examination.model.examen;

import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

public class ChoixMultiples {
	public ChoixMultiples(List<Choix> choix, BigInteger correction) {
		super();
		this.choix = choix;
		this.correction = correction;
	}

	@XmlElement(required = true)
	private List<Choix> choix;
	@XmlSchemaType(name = "positiveInteger")
	@XmlElement(required = true)
	private BigInteger correction;

	public ChoixMultiples() {
	}

	public List<Choix> getChoix() {
		return choix;
	}

	public void setChoix(List<Choix> choix) {
		this.choix = choix;
	}

	public BigInteger getCorrection() {
		return correction;
	}

	public void setCorrection(BigInteger correction) {
		this.correction = correction;
	}
}