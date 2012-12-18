/**
 * Part of the project : examination-middleware
 * fr.emn.examination.persistence.impl.MockExaminationDAO.java Created by :
 * pierre
 */
package fr.emn.examination.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import fr.emn.examination.model.examen.Examen;
import fr.emn.examination.persistence.GenericDAO;

/**
 * @author pierre
 * 
 */
public class MockExaminationDAO implements GenericDAO<Examen> {
    
    private List<Examen> inMemoryDB = new ArrayList<Examen>();
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#create(java.lang.Object)
     */
    @Override
    public void create(Examen t) {
        System.out.print("Size before adding the exam in the DB : "
                + this.inMemoryDB.size());
        this.inMemoryDB.add(t);
        System.out.println(" <--> After the insertion : "
                + this.inMemoryDB.size());
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#remove(java.lang.String)
     */
    @Override
    public void remove(String key) {
        for (int i = 0, size = this.inMemoryDB.size(); i < size; i++) {
            if (this.inMemoryDB.get(i).getIntroduction().equals(key)) {
                this.inMemoryDB.remove(i);
                break;
                // TODO add an identifier to delete and retrieve the exam
            }
        }
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#retrieveAll()
     */
    @Override
    public List<Examen> retrieveAll() {
        return this.inMemoryDB;
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#retrieveByKey(java.lang.String)
     */
    @Override
    public Examen retrieveByKey(String key) {
        for (int i = 0, size = this.inMemoryDB.size(); i < size; i++) {
            if (this.inMemoryDB.get(i).getIntroduction().equals(key)) {
                return this.inMemoryDB.get(i);
                // TODO add an identifier to delete and retrieve the exam
            }
        }
        return null;
    }
    
    /**
     * @see fr.emn.examination.persistence.GenericDAO#update(java.lang.String,
     *      java.lang.Object)
     */
    @Override
    public void update(String key, Examen updated) {
        for (int i = 0, size = this.inMemoryDB.size(); i < size; i++) {
            if (this.inMemoryDB.get(i).getIntroduction().equals(key)) {
                this.inMemoryDB.set(i, updated);
                // TODO add an identifier to delete and retrieve the exam
            }
        }
    }
    
}
