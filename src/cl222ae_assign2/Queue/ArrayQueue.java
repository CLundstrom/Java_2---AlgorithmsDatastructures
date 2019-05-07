package cl222ae_assign2.Queue;

import java.util.Iterator;

/**
 * ArrayQueue.java
 *
 * @Author: Christoffer Lundström
 * @Date: 13/02/19
 * <p>
 * Logic for an Array Queue.
 */

public class ArrayQueue implements Queue {

    private final int EMPTY = -1;
    private int head = EMPTY; // empty
    private int tail = EMPTY; // empty
    private Object[] queue = new Object[8];
    private int arrSize = queue.length;
    private int size = 0;

    /**
     * @return size Returns the size of the array.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return Returns a boolean for the isEmpty state.
     */
    @Override
    public boolean isEmpty() {
        return head == EMPTY && tail == EMPTY; // is empty when both head and tail are -1.
    }

    /**
     * @return Returns a boolean for isFull state.
     */
    public boolean isFull() {
        return next() == head; // queue is full when tail has come around to head-index.
    }

    private int previous() {
        return (tail - 1) % arrSize;
    }

    /**
     * @param element Object which will be assigned to next element in the Circular Array.
     */
    private void assignNext(Object element) {
        tail = next();
        queue[tail] = element;
        size++;
    }

    /**
     * @return Returns the Next position for the circular array.
     */
    private int next() {
        return (tail + 1) % arrSize;
    }

    /**
     * @param element Enqueues Object.
     */
    @Override
    public void enqueue(Object element) {
        if (isFull()) {
            resize();
            assignNext(element);

        } else if (isEmpty()) { // start from 0
            head = 0;
            tail = 0;
            queue[tail] = element;
            size++;
        } else {
            assignNext(element);
        }
    }

    /**
     * Resizes array if need be.
     */
    private void resize() {
        Object[] tmp = new Object[2 * queue.length];
        for (int i = 0; i < arrSize; i++) {
            tmp[i] = queue[i];
        }
        arrSize = tmp.length; //update arrSize
        queue = tmp;
    }

    /**
     * @return Returns the dequeued object.
     */
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("No objects in queue.");
        }
        // 1 element in queue
        else if (head == tail) {
            queue[head] = null;
            head = EMPTY;
            tail = EMPTY;
            size--;
        } else {
            Object obj = queue[head];
            queue[head] = null; // remove element
            head = (head + 1) % arrSize; //circular move
            size--;
            return obj;
        }
        return null;
    }

    /**
     * @return Returns first object in Queue.
     */
    @Override
    public Object first() {
        return queue[head] != null ? queue[head] : new String("No objects in queue.");
    }

    /**
     * @return Returns last object in Queue.
     */
    @Override
    public Object last() {
        return queue[tail] != null ? queue[tail] : new String("No objects in queue.");
    }

    /**
     * @return Returns an iterator designed for the queue.
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            int index = head; // start point for iterator is at start of queue.

            @Override
            public boolean hasNext() {
                if (index < 0) {
                    return false;
                } else {
                    return queue[index] != null;
                }
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    // return current value and set index to next.
                    Object obj = queue[index];
                    index++;
                    return obj;
                }
                throw new IndexOutOfBoundsException("Cannot iterate an empty list.");
            }
        };
    }

}
