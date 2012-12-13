package fr.emn.services.compilation;

import java.util.List;

public interface Compiler<T extends SourceFile> {
	/**
	 * Compile the given source files and return the output of the compiler
	 * @param sourceFiles source files to compile
	 * @return error messages if any.
	 */
	Result compile(List<T> sourceFiles);
	
	/**
	 * @param className
	 * @param functionName
	 * @return
	 */
	String execute(String className, String functionName, Object[] args);
	
}
