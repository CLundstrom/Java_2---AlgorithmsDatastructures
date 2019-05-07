package cl222ae_assign4.binheap.priorityqueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * BinaryHeapQueue.java
 *
 * @Author: Christoffer
 * @Date: 13/03/2019
 * <p>
 * <p>
 * Implementation of BinaryHeapQueue
 */
public class BinaryHeapQueue implements PriorityQueue {

    private int capacity = 8;
    private int size = 0;
    private Task[] nodes;

    BinaryHeapQueue(int capacity) {
        this.capacity = capacity;
        nodes = new WorkTask[capacity];
    }

    /**
     * @return Capacity of the heap.
     */

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Inserts element to the heap and calls for adjustment to the right position in the heap.
     *
     * @param t Inserts task.
     */
    public void insert(Task t) {
        ensureCapacity();
        this.size++;
        nodes[size] = t; // prio

        percolateUp(size);
    }

    /**
     * Returns and removes the top value from the heap.
     *
     * @return Highest value of the heap.
     */
    public Task pullHighest() {
        if (!isEmpty()) {
            Task tmp = nodes[1];
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

    public boolean isEmpty() {
        return this.size == 0 || nodes == null;
    }

    @Override
    public boolean contains(Task t) {

        for (int i = 0; i < size; i++) {
            if (nodes[i].equals(t)) return true;
        }

        return false;
    }

    /**
     * Ensures that the array is large enough for the values.
     */
    private void ensureCapacity() {
        if (size + 1 == capacity) {
            resize();
        }
    }

    /**
     * Deletes the top value. Swaps it to the last index and perculates the top value downwards in the tree.
     */
    private void delete() {
        nodes[1] = null; //always delete top element.
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

            if (hasRightChild(index) && getRightChild(index).getPriority() > getLeftChild(index).getPriority()) {

                smallerChildIndex = getRightChildIndex(index);
            }

            if (nodes[index].getPriority() > nodes[smallerChildIndex].getPriority()) {
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
        while (hasParent(index) && getParent(index).getPriority() < nodes[index].getPriority()) {
            swapIndex(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * Doubles the array size if needed.
     */
    private void resize() {
        nodes = Arrays.copyOf(nodes, this.capacity * 2);
        this.capacity *= 2;
    }

    /**
     * Swaps places of two elements in the heap.
     *
     * @param indexOne First element.
     * @param indexTwo Second element.
     */
    private void swapIndex(int indexOne, int indexTwo) {
        Task tmp = nodes[indexOne]; // prio

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

    private Task getParent(int index) {
        return nodes[getParentIndex(index)];
    }

    private Task getLeftChild(int index) {
        return nodes[getLeftChildIndex(index)];
    }

    private Task getRightChild(int index) {
        return nodes[getRightChildIndex(index)];
    }

    private int getParentIndex(int childindex) {
        return (childindex) / 2;
    }

    public Iterator<Task> iterator() {
        return new Iterator<>() {
            int index = 1;

            public boolean hasNext() {
                return nodes[index] != null;
            }

            public Task next() {
                if (hasNext()) {
                    return nodes[index++];
                }
                throw new NullPointerException("Cannot iterate an empty list.");
            }
        };
    }
}
