/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.emn.examination.model.Role;
import fr.emn.examination.model.User;
import fr.emn.examination.persistence.Factory;

/**
 * @author Cedric Nisio
 * 
 */
public class Register implements Serializable {

    /**
     * long
     */
    private static final long serialVersionUID = -1428734022613190652L;

    private String            login;

    private String            password;

    private String            confirmPassword;

    /**
     * 
     */
    public Register() {
	super();
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	        .getExternalContext().getSession(false);
	if (session != null) {
	    session.invalidate();
	}
    }

    /**
     * @param password
     * @param role
     * @param userName
     */
    public Register(String password, String confirmPassword, String login) {
	this();
	this.login = login;
	this.password = password;
	this.confirmPassword = confirmPassword;
    }

    /**
     * @return the username
     */
    public String getLogin() {
	return this.login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return this.password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
	return this.confirmPassword;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * @param confirmPassword
     *            the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
    }

    public String register() {
	User userWithSameLogin = Factory.getUserDAO().retrieveByKey(getLogin());
	if (userWithSameLogin == null
	        && getPassword().equals(getConfirmPassword())) {
	    User newUser = new User(getPassword(), Role.STUDENT, getLogin());
	    Factory.getUserDAO().create(newUser);
	    return "success";
	}
	return "failure";
    }

}
