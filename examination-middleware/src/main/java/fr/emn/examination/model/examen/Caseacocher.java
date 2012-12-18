package fr.emn.examination.model.examen;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Caseacocher {
	public Caseacocher(List<Case> _case) {
		super();
		this._case = _case;
	}

	@XmlElement(name = "case", required = true)
	private List<Case> _case;

	public Caseacocher() {
	}

	public List<Case> get_case() {
		return _case;
	}

	public void set_case(List<Case> _case) {
		this._case = _case;
	}
}