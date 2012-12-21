/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.model;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import fr.emn.examination.parser.ExamenParser;
import fr.emn.examination.parser.JavaCodeParser;
import fr.emn.examination.persistence.Factory;
import fr.emn.examination.util.Coding;

/**
 * @author Pierre Reliquet
 * 
 */
public class User implements Serializable {

    /**
     * long
     */
    private static final long serialVersionUID = -1428734022613190652L;

    private String            password;

    private Role              role;

    private String            userName;

    private ExamenStudent     examen;

    /**
     * 
     */
    public User() {
	super();
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	        .getExternalContext().getSession(false);
	if (session != null) {
	    session.invalidate();
	}
	String xmlString = Factory.getExamenXMLDAO().retrieveAll().get(1);
	ExamenParser parserXml = new ExamenParser();
	String javaString = Factory.getExamenXMLDAO().retrieveAll().get(2);
	JavaCodeParser parserJava = new JavaCodeParser(javaString);

	try {
	    examen = new ExamenStudent(parserXml.getFromString(xmlString),
		    parserJava.getJavaCode());
	}
	catch (JAXBException e) {
	    e.printStackTrace();
	    examen = new ExamenStudent(); // TODO la meilleure solution serait
		                          // de relancer l'exception au niveau
		                          // superieur
	}
    }

    /**
     * @param password
     * @param role
     * @param userName
     */
    public User(String password, Role role, String userName) {
	this();
	this.password = new Coding().plainStringToMD5(password + userName);
	this.role = role;
	this.userName = userName;
    }

    /**
     * @param password
     * @param userName
     */
    public User(String password, String userName) {
	this();
	this.password = new Coding().plainStringToMD5(password + userName);
	this.userName = userName;
	this.role = Role.STUDENT;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return this.password;
    }

    /**
     * @return the role
     */
    public Role getRole() {
	return this.role;
    }

    /**
     * @return the username
     */
    public String getUserName() {
	return this.userName;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(Role role) {
	this.role = role;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }

    public ExamenStudent getExamen() {
	return examen;
    }

    public void setExamen(ExamenStudent examen) {
	this.examen = examen;
    }

}
