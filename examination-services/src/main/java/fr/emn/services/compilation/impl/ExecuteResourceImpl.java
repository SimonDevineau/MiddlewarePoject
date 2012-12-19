package fr.emn.services.compilation.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.emn.services.compilation.ExecuteResource;
import fr.emn.services.compilation.ExecuteResult;

@Path("/execute")
public final class ExecuteResourceImpl implements ExecuteResource {
	/* (non-Javadoc)
	 * @see fr.emn.services.compilation.impl.ExecuteResource#execute(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@POST
	@Produces(MediaType.TEXT_XML)
	public ExecuteResult execute(@FormParam("className") String className,
			@FormParam("sourceCode") String sourceCode,
			@FormParam("function") String function) {


		InMemoryJavaFile file = new InMemoryJavaFile(className, sourceCode);
		List<InMemoryJavaFile> files = new ArrayList<InMemoryJavaFile>();
		files.add(file);

		CustomJavaCompiler compiler = new CustomJavaCompiler();

		ExecuteResult executeResult = new ExecuteResult();

		if (compiler.compile(files).hasSucceeded() == true) {
			executeResult = compiler.execute(className, function,
					null);
		}
		return executeResult;
	}

}
