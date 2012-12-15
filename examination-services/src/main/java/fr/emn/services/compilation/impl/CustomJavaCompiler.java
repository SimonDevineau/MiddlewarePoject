package fr.emn.services.compilation.impl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;

import org.eclipse.jdt.internal.compiler.tool.EclipseCompiler;

import fr.emn.services.compilation.Compiler;
import fr.emn.services.compilation.Result;

public class CustomJavaCompiler implements Compiler<InMemoryJavaFile> {

	private ClassFileManager fileManager;

	public ClassFileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(ClassFileManager fileManager) {
		this.fileManager = fileManager;
	}
//TODO mesurer le temps de compilation
	@Override
	public Result compile(List<InMemoryJavaFile> sourceFiles) {

		JavaCompiler compiler = new EclipseCompiler();
		this.fileManager = new fr.emn.services.compilation.impl.ClassFileManager(
				compiler.getStandardFileManager(null, null, null));

		StringWriter writer = new StringWriter();

		CompilationTask cTask = compiler.getTask(writer, fileManager, null,
				null, null, sourceFiles);

		Result res = new Result();
		res.setSucceed(cTask.call());


		res.setOutput(writer.toString());

		return res;
	}
//TODO mesurer le temps d'exécution
	@Override
	public Result execute(String className, String functionName, Object[] args) {
		Result toReturn = new Result();
		Object executionResult = null;
		ClassLoader classLoader = fileManager.getClassLoader(null);
		try {
			Class<?> loadedClass = classLoader.loadClass(className);
			
			Method method = loadedClass.getMethod(functionName,
					(Class<?>[]) null);

			
			executionResult = method.invoke(null, args);
			toReturn.setSucceed(true);
			toReturn.setOutput(executionResult.toString());
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch(Exception e) {
			toReturn.setError(e.getMessage());
			toReturn.setSucceed(false);
		}
		return toReturn;
	}

	public static void main(String[] args) {
		StringBuilder src = new StringBuilder();
		src.append("public class DynaClass {\n");
		src.append("    public static void main(String[] args) {\n");
		src.append("        System.out.println(\"Hello, I am \" + ");
		src.append(" \"a class\");\n");
		src.append("    }\n");
		src.append("}\n");

		InMemoryJavaFile file = new InMemoryJavaFile("DynaClass", src);
		List<InMemoryJavaFile> files = new ArrayList<InMemoryJavaFile>();
		files.add(file);

		CustomJavaCompiler compiler = new CustomJavaCompiler();
		System.out.println(compiler.compile(files));
		String[] params = new String[0];
		System.out.println(" execution : "
				+ compiler
						.execute("DynaClass", "main", new Object[] { params }));

	}

}
