package cl222ae_assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;

/**
 * IdentifyWordsMain.java
 *
 * @Author: Christoffer
 * @Date: 25/02/2019
 */
public class IdentifyWordsMain {


    private static String path = "src/cl222ae_assign3/count_words/HistoryOfProgramming.txt";

    public static void main(String[] args) {

        try {

            File file = new File("src/cl222ae_assign3/count_words/words.txt");
            HashSet<String> set = new HashSet<>();
            // Using standard UTF-8, changable should there be any encoding issues.
            String text = readText(path, StandardCharsets.UTF_8);
            //All non-letters (except whitespace) should be removed
            text = text.replaceAll("[^A-Za-z\\s]+", "");

            String[] textSplit = text.split("[\\s]+");

            for (String s : textSplit) {
                set.add(s);
            }
            Files.write(file.toPath(), text.getBytes());
            System.out.println("Words: " + set.size());

        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    /**
     *
     * @param path Path to text-file.
     * @param cs Encoding of text.
     * @return Reads and returns a string.
     * @throws IOException
     */
    public static String readText(String path, Charset cs) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)), cs);
    }


}

