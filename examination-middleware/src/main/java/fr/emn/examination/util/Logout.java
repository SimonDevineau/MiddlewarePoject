/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.util;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author Cedric Nisio
 * 
 */
public class Logout implements Serializable {

    /**
     * long
     */
    private static final long serialVersionUID = -1428734022613190652L;

    /**
     * 
     */
    public Logout() {
    }

    public String logout() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
	        .getExternalContext().getSession(false);
	session.invalidate();
	return "logout";
    }
}
