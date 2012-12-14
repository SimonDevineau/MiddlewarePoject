/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.model;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.emn.examination.persistence.Factory;

/**
 * @author Cedric Nisio
 * 
 */
public class Login implements Serializable {
    
    /**
     * long
     */
    private static final long serialVersionUID = -1428734022613190652L;
    
    private String            login;
    
    private String            password;
    
    /**
     * 
     */
    public Login() {
    	super();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session != null){
            session.invalidate();
        }
    }
    
    /**
     * @param password
     * @param role
     * @param userName
     */
    public Login(String password, String login) {
        this();
        this.login = login;
        this.password = password;
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
    
    public String login(){
    	User user = Factory.getUserDAO().retrieveByKey(this.getLogin());
    	if(user!=null&&user.getPassword().equals(this.getPassword())) {
    		Session.put("currentUser", user);
    		Session.put("connected", true);
    		return "success";
    	}
    	return "failure";
    }
    public void logout(){
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
    }
}
