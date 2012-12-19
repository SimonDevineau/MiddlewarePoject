package fr.emn.examination.servicesinterface;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import fr.emn.services.compilation.CompileResource;
import fr.emn.services.compilation.Result;

public final class Compilation{
	public static final String SERVICE_PATH1 = "http://compilemiddleware-aurelienrichez.rhcloud.com/services";
	public static final String SERVICE_PATH2 = "http://localhost:8080/examination-services/services";
	
	public static Result compile( String className, String sourceCode) {
		CompileResource proxy = JAXRSClientFactory.create(SERVICE_PATH1, CompileResource.class);
		return proxy.compile(className, sourceCode);
	}
	
}
