package cl222ae_assign4.binheap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * BinaryIntHeap.java
 *
 * @Author: Christoffer
 * @Date: 11/03/2019
 *
 * <p>
 * <p>
 * Using the Horstmann Approach together with inspiration from a Min heap approach.
 * <p>
 * HackerRank @ Youtube.
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&
 */
public class BinaryIntHeap implements IBinaryHeap {

    private int maxSize = 8; // defaults
    private int size = 0;
    private int[] nodes = new int[maxSize];

    public void BinaryIntHeap() {
    }

    public void BinaryIntHeap(int capacity) {
        nodes = new int[capacity];
    }

    /**
     * @return Capacity of the heap.
     */
    public int getCapacity() {

        return this.maxSize;
    }

    /**
     * Inserts element to the heap and calls for adjustment to the right position in the heap.
     *
     * @param n
     */
    @Override
    public void insert(int n) {
        ensureCapacity();
        this.size++;
        nodes[size] = n;
        percolateUp(size);
    }

    /**
     * Returns and removes the top value from the heap.
     *
     * @return Highest value of the heap.
     */
    @Override
    public int pullHighest() {
        if (!isEmpty()) {
            int tmp = nodes[1];
            delete();
            size--;
            return tmp;
        }
        throw new NoSuchElementException("No elements in the heap.");
    }


    /**
     * @return Element count of heap.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @return Status of the array.
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0 || nodes == null;
    }


    /**
     * Ensures that the array is large enough for the values.
     */
    private void ensureCapacity() {
        if (size + 1 == maxSize) {
            resize();
        }
    }

    /**
     * Deletes the top value. Swaps it to the last index and perculates the top value downwards in the tree.
     */
    private void delete() {
        nodes[1] = 0; //always delete top element.
        swapIndex(1, size); //swap with the last element to then
        percolateDown();
    }


    /**
     * Downward motion of the binary heap.
     */
    private void percolateDown() {
        int index = 1;

        while (hasLeftChild(index)) {

            int smallerChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {

                smallerChildIndex = getRightChildIndex(index);
            }

            if (nodes[index] > nodes[smallerChildIndex]) {
                break;
            } else {
                swapIndex(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    /**
     * Makes sure the added value gets the correct position in the heap.
     *
     * @param index Position of the index to be perculated.
     */
    private void percolateUp(int index) {

        while (hasParent(index) && getParent(index) < nodes[index]) {
            swapIndex(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * Doubles the array size if needed.
     */
    private void resize() {
        nodes = Arrays.copyOf(nodes, this.maxSize * 2);
        this.maxSize *= 2;
    }

    /**
     * Swaps places of two elements in the heap.
     *
     * @param indexOne First element.
     * @param indexTwo Second element.
     */
    private void swapIndex(int indexOne, int indexTwo) {
        int tmp = nodes[indexOne];
        nodes[indexOne] = nodes[indexTwo];
        nodes[indexTwo] = tmp;
    }


    private boolean hasParent(int n) {
        return getParentIndex(n) > 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {

        return getRightChildIndex(index) < size;
    }

    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getParent(int index) {
        return nodes[getParentIndex(index)];
    }

    private int getLeftChild(int index) {
        return nodes[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return nodes[getRightChildIndex(index)];
    }

    private int getParentIndex(int childindex) {
        return (childindex) / 2;
    }


}
