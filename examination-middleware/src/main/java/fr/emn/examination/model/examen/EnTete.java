package fr.emn.examination.model.examen;

import javax.xml.bind.annotation.XmlElement;

public class EnTete {
	public EnTete(String titre, String objet, String date, String auteur,
			String source) {
		super();
		this.titre = titre;
		this.objet = objet;
		this.date = date;
		this.auteur = auteur;
		this.source = source;
	}

	@XmlElement(required = true)
	private String titre;
	private String objet;
	private String date;
	private String auteur;
	private String source;

	public EnTete() {
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}