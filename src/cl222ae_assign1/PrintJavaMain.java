package cl222ae_assign1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * PrintJavaMain.java
 * 
 * @author Christoffer Lundström
 * @date: 28 Jan 2019
 */
public class PrintJavaMain {

	public static void main(String[] args)  {
		String path = args.length == 0 ? "D:\\Google Drive\\source\\eclipse\\1DV506\\src": args[0];
		
		try {
		System.out.println("\nTotal: " + printAllJavaFiles(new File(path)) + " bytes");
		}
		
		catch(IOException e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * Prints all .java and directories within file or dir.
	 * 
	 * @param dir Local or full path to file or directory.
	 * @throws IOException
	 * @throws MalformedInputException
	 */
	public static long printAllJavaFiles(File dir) throws IOException {
		long size = 0; // Top parent size.

		if (dir.isDirectory()) {
			System.out.println(dir.getName() + ":");
			File[] files = dir.listFiles(); // Listing all files in directory. Including non-java files. They will be
											// excluded later.

			for (int i = 0; files != null && i < files.length; i++) {

				if (files[i].getName().endsWith(".java")) {
					
					long count = 0;
					try {
						var stream = Files.lines(files[i].toPath(), StandardCharsets.ISO_8859_1); // Default ANSI-encoding in eclipse
						count = stream.count();
						stream.close();
					}
					
					catch(java.nio.charset.MalformedInputException e ) {
						var stream = Files.lines(files[i].toPath(), StandardCharsets.UTF_8); // Incase ANSI throws
						count = stream.count();
						stream.close();
					}
					
					System.out.println("\t- " + files[i].getName() + "\t" + count + " rows");

				}

				else if (files[i].isDirectory()) {
					System.out.println("\t- " + files[i].getName() + " {folder}");
				}

				size += printAllJavaFiles(files[i]); // Recursive
			}
		} else {
			size += dir.length();
		}
		return size;
	}
}
