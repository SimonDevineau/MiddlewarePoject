package fr.emn.examination.servicesinterface;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import fr.emn.services.compilation.ExecuteResource;
import fr.emn.services.compilation.ExecuteResult;


public final class Execution {

	public static final String SERVICE_PATH1 = "http://compilemiddleware-aurelienrichez.rhcloud.com/services";
	public static final String SERVICE_PATH2 = "http://localhost:8080/examination-services/services";
	
	
	
	public static ExecuteResult execute(String className, String sourceCode, String function) {
		ExecuteResource proxy = JAXRSClientFactory.create(SERVICE_PATH1, ExecuteResource.class);
		return proxy.execute(className, sourceCode, function);
	}
	
}
