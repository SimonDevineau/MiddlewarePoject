package fr.emn.services.compilation.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.emn.services.compilation.CompileResource;
import fr.emn.services.compilation.Result;

@Path("/compile")
public final class CompileResourceImpl implements CompileResource {

	
	/* (non-Javadoc)
	 * @see fr.emn.services.compilation.impl.CompileResource#compile(java.lang.String, java.lang.String)
	 */
	@Override
	@POST
	@Produces(MediaType.TEXT_XML)
	public Result compile(@FormParam("className") String fileName,
			@FormParam("sourceCode") String sourceCode) {
		
		String className = fileName.replace(".java", "");
		
		InMemoryJavaFile file = new InMemoryJavaFile(className, sourceCode);
		List<InMemoryJavaFile> files = new ArrayList<InMemoryJavaFile>();
		files.add(file);
		

		CustomJavaCompiler compiler = new CustomJavaCompiler();
		
		return compiler.compile(files);
	}
}
