package je.panse.doro.commoncode.item_administratus;

import java.io.IOException;
import java.io.InputStream;

public class Run_another_jar {

	public static void main(String jarargs) throws IOException {
		// Run a java app in a separate system process
		Process proc = Runtime.getRuntime().exec(jarargs);
		// Then retreive the process output
		InputStream in = proc.getInputStream();
		InputStream err = proc.getErrorStream();
	}

}
