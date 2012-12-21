package fr.emn.examination.controller;


import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.FileUploadEvent;  

import fr.emn.examination.persistence.Factory;
import fr.emn.examination.persistence.GenericDAO;
  
public class FileUploadController {  
  
    public void handleFileUpload(FileUploadEvent event) {  
    	GenericDAO<String> dao = Factory.getExamenXMLDAO();
    	String file=new String(event.getFile().getContents());
	    
    	dao.create(file);
    	
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}  
