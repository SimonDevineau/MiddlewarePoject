/**
 * Part of the project : examination-middleware
 * fr.emn.examination.persistence.Factory.java Created by : pierre
 */
package fr.emn.examination.persistence;

import fr.emn.examination.model.User;
import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.persistence.impl.MockExaminationDAO;
import fr.emn.examination.persistence.impl.MockUserDAO;

/**
 * @author pierre
 * 
 */
public class Factory {
    
    private static volatile GenericDAO<Examen> examenDAO = null;
    
    private static volatile GenericDAO<User>   userDAO   = null;
    
    public static synchronized GenericDAO<Examen> getExamenDAO() {
        if (examenDAO == null) {
            examenDAO = new MockExaminationDAO();
        }
        return examenDAO;
    }
    
    public static synchronized GenericDAO<User> getUserDAO() {
        if (userDAO == null) {
            userDAO = new MockUserDAO();
        }
        return userDAO;
    }
    
}
