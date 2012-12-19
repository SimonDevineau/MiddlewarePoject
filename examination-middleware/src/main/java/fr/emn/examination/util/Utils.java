package fr.emn.examination.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class Utils {
	public static String loadFile(String s) {
		try {
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(s));
			StringWriter out = new StringWriter();
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			out.flush();
			out.close();
			in.close();
			return out.toString();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return "";
	}
}
