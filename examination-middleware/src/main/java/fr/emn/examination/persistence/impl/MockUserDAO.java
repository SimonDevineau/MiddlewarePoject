/**
 * Part of the project : examination
 * fr.emn.examination.persistence.impl.UserDAO.java Created by : pierre
 */
package fr.emn.examination.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import fr.emn.examination.model.Role;
import fr.emn.examination.model.User;
import fr.emn.examination.persistence.GenericDAO;

/**
 * @author Pierre Reliquet
 * 
 */
public class MockUserDAO implements GenericDAO<fr.emn.examination.model.User> {
    
    private List<User> inMemoryDB = new ArrayList<User>();
    
    /**
     * 
     */
    public MockUserDAO() {
        this.inMemoryDB.add(new User("student", "student"));
        this.inMemoryDB.add(new User("student1", "student1"));
        this.inMemoryDB.add(new User("administrator", Role.ADMINISTRATOR,
                "administrator"));
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#create(java.lang.Object)
     */
    @Override
    public void create(User t) {
        this.inMemoryDB.add(t);
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#remove(java.lang.String)
     */
    @Override
    public void remove(String key) {
        int end = this.inMemoryDB.size();
        int index = 0;
        for (; index < end; index++) {
            if (this.inMemoryDB.get(index).getUserName().equals(key)) {
                break;
            }
        }
        
        if (index < end) {
            this.inMemoryDB.remove(index);
        }
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#retrieveAll()
     */
    @Override
    public List<User> retrieveAll() {
        return this.inMemoryDB;
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#retrieveByKey(java.lang.String)
     */
    @Override
    public User retrieveByKey(String key) {
        for (int index = 0, end = this.inMemoryDB.size(); index < end; index++) {
            if (this.inMemoryDB.get(index).getUserName().equals(key)) {
                return this.inMemoryDB.get(index);
            }
        }
        return null;
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#update(java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void update(String key, User updated) {
        for (int index = 0, end = this.inMemoryDB.size(); index < end; index++) {
            if (this.inMemoryDB.get(index).getUserName().equals(key)) {
                this.inMemoryDB.set(index, updated);
            }
        }
    }
}
