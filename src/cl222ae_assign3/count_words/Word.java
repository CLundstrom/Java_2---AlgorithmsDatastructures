package cl222ae_assign3.count_words;

/**
 * Word.java
 *
 * @Author: Christoffer
 * @Date: 25/02/2019
 */
public class Word implements Comparable<Word> {

    private String word;
    private Word next = null;


    public Word(String str) {
        this.word = str;
    }


    public void setNext(Word w) {
        next = w;
    }

    public Word getNext() {
        return next;
    }

    public String toString() {
        return word;
    }

    /* Override Object methods */
    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word w = (Word) other;
            return word.equalsIgnoreCase(((Word) other).word) && word.hashCode() == other.hashCode();
        }

        return false;
    }

    /* Implement Comparable ... compares two words lexicographically */
    @Override
    public int compareTo(Word w) {

        return this.word.compareToIgnoreCase(w.word);
    }

}

