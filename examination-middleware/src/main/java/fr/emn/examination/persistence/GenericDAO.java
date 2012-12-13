/**
 * Part of the project : examination
 * fr.emn.examination.persistence.GenericDAO.java Created by : pierre
 */
package fr.emn.examination.persistence;

import java.util.List;

/**
 * @author Pierre
 * 
 */
public interface GenericDAO<T> {
    
    void create(T t);
    
    void remove(String key);
    
    List<T> retrieveAll();
    
    T retrieveByKey(String key);
    
    void update(String key, T updated);
    
}
