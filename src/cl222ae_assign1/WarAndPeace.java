package cl222ae_assign1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * WarAndPeace.java
 * 
 * @author Christoffer Lundström
 * @date: 27 Jan 2019
 */
public class WarAndPeace {

	public static void main(String[] args)  {

		try {
			
			// Using standard UTF-8, changable should there be any encoding issues.
			var text = readText("WarAndPeace.txt", StandardCharsets.UTF_8);
		
			// Split at everything EXCEPT characters A-Z and '- ’ and ‘
			String[] words = text.split("[^A-Za-z'‘’-]+");
			
			System.out.println("Initial word count: " + words.length);

			// Everything to lower case since we're ignoring casing.
			Stream<String> stream = Arrays.stream(words).map(String::toLowerCase);

			long count = stream.distinct().count();

			stream.close();
			System.out.println("Unique words: " + count);
			
		} 
		catch (IOException e) {
			System.out.println(e.toString());
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	public static String readText(String path, Charset cs) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)), cs);
	}

}