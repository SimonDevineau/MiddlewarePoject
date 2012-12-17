package fr.emn.services.compilation.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/execute")
public final class ExecuteResource {
	@POST
	@Produces(MediaType.TEXT_XML)
	public static ExecuteResult execute(@FormParam("fileName") String fileName,
			@FormParam("sourceCode") String sourceCode,
			@FormParam("function") String function) {

		String className = fileName.replace(".java", "");

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
