package fr.emn.services.compilation;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public interface CompileResource {

	@POST
	@Produces(MediaType.TEXT_XML)
	Result compile(@FormParam("className") String fileName,
			@FormParam("sourceCode") String sourceCode);

}