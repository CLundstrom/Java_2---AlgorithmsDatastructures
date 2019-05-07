package cl222ae_assign3.count_words;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * WordCount1Main.java
 *
 * @Author: Christoffer
 * @Date: 25/02/2019
 */
public class WordCount1Main {

    private static Path path = Paths.get("src/cl222ae_assign3/count_words/words.txt");

    public static void main(String[] args) {

        HashSet<Word> hash = new HashSet<>();
        TreeSet<Word> tree = new TreeSet<>();


        try {
            String text = new String(Files.readAllBytes(path));


            String[] split = text.split("[\\s]+");

            for (String s : split) {
                hash.add(new Word(s));
                tree.add(new Word(s));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Iterator itTree = tree.iterator();
        while (itTree.hasNext()) {
            System.out.println(itTree.next());
        }

        System.out.println("\nHash size: " + hash.size());
        System.out.println("Tree size: " + tree.size());

    }
}
