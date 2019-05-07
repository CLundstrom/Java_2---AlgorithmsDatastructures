package cl222ae_assign3.count_words;

import java.util.Iterator;

/**
 * TreeWordSet.java
 *
 * @Author: Christoffer
 * @Date: 25/02/2019
 */
public class TreeWordSet implements WordSet {

    private Node root = null;
    private int size = 0;
    private Word[] list = new Word[370];
    private int index = 0;

    /**
     * Inner class
     */
    private class Node {

        Word value; // Node has Word as a value.

        Node leftChild = null;
        Node rightChild = null;

        public Node(Word val) {
            value = val;
        }

        void add(Word word) {
            if (word.compareTo(value) < value.compareTo(word)) { // left
                if (leftChild == null)
                    leftChild = new Node(word);
                else
                    leftChild.add(word);
            } else if (word.compareTo(value) > value.compareTo(word)) { // right
                if (rightChild == null)
                    rightChild = new Node(word);
                else
                    rightChild.add(word);
            }
        }

        boolean contains(Word word) {
            if (word.compareTo(value) < value.compareTo(word)) { // left branch
                if (leftChild == null)
                    return false;
                else
                    return leftChild.contains(word);
            } else if (word.compareTo(value) > value.compareTo(word)) { // right branch
                if (rightChild == null)
                    return false;
                else
                    return rightChild.contains(word);
            }
            return true; // Found!
        }

        void traverse() {
            if (leftChild != null) {
                leftChild.traverse();
            }
            list[index] = value;
            index++;

            if (rightChild != null) {
                rightChild.traverse();
            }
        }
    }

    public void add(Word n) {
        if (root == null) {
            root = new Node(n);
            size++;
        } else {
            if (contains(n)) return;
            root.add(n);
            size++;
        }
    }

    @Override
    public boolean contains(Word word) {
        return root.contains(word);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator();
    }

    /**
     * Iterator with a list of Words added.
     *
     */
    private class NodeIterator implements Iterator {

        Node tmp = root;
        int index = 0;
        Word[] words;


        public NodeIterator() {
            tmp.traverse(); // fill list
            words = list;
        }

        @Override
        public boolean hasNext() {
            return words[index] != null && index < words.length;
        }

        @Override
        public Object next() {

            return words[index++];
        }
    }
}
