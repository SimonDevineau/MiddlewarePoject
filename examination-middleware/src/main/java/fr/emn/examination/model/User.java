/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.model;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.emn.examination.persistence.Factory;

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
    
    /**
     * 
     */
    public User() {
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
    public User(String password, Role role, String userName) {
        this();
        this.password = password;
        this.role = role;
        this.userName = userName;
    }
    
    /**
     * @param password
     * @param userName
     */
    public User(String password, String userName) {
        this();
        this.password = password;
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
    
}
