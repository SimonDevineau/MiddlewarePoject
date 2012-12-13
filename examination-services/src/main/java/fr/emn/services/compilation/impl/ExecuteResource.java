package fr.emn.services.compilation.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.emn.services.compilation.GlobalResult;

@Path("/execute")
public final class ExecuteResource {
	@POST
	@Produces(MediaType.TEXT_XML)
	public static GlobalResult execute(@FormParam("fileName") String fileName,
			@FormParam("sourceCode") String sourceCode) {
		
		String className = fileName.replace(".java", "");
		
		InMemoryJavaFile file = new InMemoryJavaFile(className, sourceCode);
		List<InMemoryJavaFile> files = new ArrayList<InMemoryJavaFile>();
		files.add(file);
		

		CustomJavaCompiler compiler = new CustomJavaCompiler();

		GlobalResult globalResult = new GlobalResult();
		
		globalResult.setCompilation(compiler.compile(files));
		if (globalResult.getCompilation().isSucceed()) {
			String[] params = new String[0];
			globalResult.getExecution()
					.setOutput(
							compiler.execute(className, "main",
									new Object[] { params }));
		}
		return globalResult;
	}

}
