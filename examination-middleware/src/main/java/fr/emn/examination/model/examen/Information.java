package fr.emn.examination.model.examen;

import javax.xml.bind.annotation.XmlElement;

public class Information {
	public Information(EnTete enTete, Destination destination, String version,
			String commentaires) {
		super();
		this.enTete = enTete;
		this.destination = destination;
		this.version = version;
		this.commentaires = commentaires;
	}

	@XmlElement(required = true)
	private EnTete enTete;
	private Destination destination;
	private String version;
	private String commentaires;

	public Information() {
	}

	public EnTete getEnTete() {
		return enTete;
	}

	public void setEnTete(EnTete enTete) {
		this.enTete = enTete;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
}