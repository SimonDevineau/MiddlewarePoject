package fr.emn.services.compilation;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/compile")
public interface CompileResource {

	@POST
	@Produces(MediaType.TEXT_XML)
	public Result compile(@FormParam("className") String className,
			@FormParam("sourceCode") String sourceCode);

}