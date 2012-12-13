/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.model;

import java.io.Serializable;

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
    
    private String            userName;
    
    /**
     * 
     */
    public User() {
    }
    
    /**
     * @param password
     * @param userName
     */
    public User(String password, String userName) {
        super();
        this.password = password;
        this.userName = userName;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
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
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
