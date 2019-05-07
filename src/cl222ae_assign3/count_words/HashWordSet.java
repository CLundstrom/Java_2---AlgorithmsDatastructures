package cl222ae_assign3.count_words;

import java.util.Iterator;

/**
 * HashWordSet.java
 *
 * @Author: Christoffer
 * @Date: 25/02/2019
 */
public class HashWordSet implements WordSet {

    private int size = 0;

    private Word[] buckets = new Word[8];


    private int getBucketIndex(String s) {
        int hashCode = s.hashCode();

        if (hashCode < 0) hashCode = -hashCode;

        return hashCode % buckets.length; // 8 / 16
    }


    private void rehash() {
        Word[] temp = buckets;

        buckets = new Word[2 * temp.length];
        size = 0; // reset size
        for (Word n : temp) {
            if (n == null) continue;
            while (n != null) {
                add(n);  //adding word to new index
                n = n.getNext();
            }
        }
    }

    @Override
    public void add(Word word) {
        int index = getBucketIndex(word.toString());

        Word node = buckets[index];

        while (node != null) {

            if (node.toString().equals(word.toString())) return; // found

            else
                node = node.getNext(); // next node
        }

        node = new Word(word.toString()); // not found, add new

        node.setNext(buckets[index]);
        buckets[index] = node;
        size++;
        if (size == buckets.length) rehash();
    }

    @Override
    public boolean contains(Word word) {
        int index = getBucketIndex(word.toString());
        Word node = buckets[index];

        while (node != null) {
            if (node.toString().equals(word.toString())) return true;

            else
                node = node.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                while (buckets[index] == null) {
                    index++;
                }
                return buckets[index++];
            }
        };
    }
}
