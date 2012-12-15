/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.util;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.emn.examination.model.Role;
import fr.emn.examination.model.User;

/**
 * @author Cedric Nisio
 * 
 */
public class Session implements Serializable {
    

	/**
     * long
     */
	private static final long serialVersionUID = -3404638135919570534L;
    
    private boolean            connected = false;
    
    public Session() {
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getUserUserName() {
		return getCurrentUserUserName();
	}

	public Role getUserRole() {
		return getCurrentUserRole();
	}

	/**
	 * 
	 * @return creation date for the current session
	 */
	public String getCreationDate() {
		long date = getCurrentSession().getCreationTime();
		return new Date(date).toString();
	}

	/**
	 * Alias to return quickly the current http session object
	 * 
	 * @return the current session
	 */
	public static HttpSession getCurrentSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (HttpSession) context.getExternalContext().getSession(true);
	}

	public static void put(Object str, Object obj) {
		Map session = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		session.put(str, obj);
	}

	public static Object get(Object obj) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(obj);
	}

	public static User getCurrentUser() {
		return (User) get("currentUser");
	}

	public static String getCurrentUserUserName() {
		return getCurrentUser().getUserName();
	}

	public static Role getCurrentUserRole() {
		return getCurrentUser().getRole();
	}
}
