package fr.emn.services.compilation;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.emn.services.compilation.ExecuteResult;

@Path("/execute")
public interface ExecuteResource {

	@POST
	@Produces(MediaType.TEXT_XML)
	public ExecuteResult execute(@FormParam("className") String className,
			@FormParam("sourceCode") String sourceCode,
			@FormParam("function") String function);

}