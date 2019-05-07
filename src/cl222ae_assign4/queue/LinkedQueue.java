package cl222ae_assign4.queue;

import java.util.Iterator;

/**
 * LinkedQueue.java
 *
 * @Author: Christoffer Lundstrom
 * @Date: 13/02/19
 * <p>
 * A linked queue using the head & tail approach.
 */
public class LinkedQueue<T> implements Queue<T> {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private class Node {

        T value;
        Node next = null; // reference to next node

        Node(T v) {
            value = v;
        }

        public String toString() {
            return value.toString();
        }
    }

    /**
     * Returns current size of the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if queue is empty, false if not.
     */
    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Enqueues specified object to the linked queue.
     *
     * @param element Object to place in queue.
     */
    @Override
    public void enqueue(T element) {
        // List empty
        if (head == null) {
            head = new Node(element);
            size++;
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
            size++;
        }
    }

    /**
     * Dequeues first object in queue.
     *
     * @throws NullPointerException
     */
    @Override
    public T dequeue() {
        if (head == null) throw new NullPointerException("No objects in queue.");
        Node tmp = head;
        head = head.next;
        size--;
        return tmp.value;
    }

    /**
     * Returns first object in queue.
     */
    @Override
    public T first() {
        if (head == null) throw new NullPointerException("No objects in queue.");
        return head.value;
    }

    /**
     * Returns last object in queue.
     */
    @Override
    public T last() {
        if (head == null) throw new NullPointerException("No objects in queue.");
        return tail.value;
    }

    /**
     * Returns string representation of the contents in the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        Iterator<T> it = iterator();

        while (it.hasNext()) {
            sb.append(it.next() + ", ");
        }

        return sb.toString();

    }

    /**
     * Returns an iterator capable of iterating over objects in the queue.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // Assign index to first Node.
            Node index = head;

            @Override
            public T next() {
                if (hasNext()) {
                    // return current value and set index to next.
                    Node currentNode = index;
                    index = index.next;
                    return currentNode.value;
                }
                throw new NullPointerException("Cannot iterate an empty list.");
            }

            @Override
            public boolean hasNext() {
                return index != null;
            }
        };

    }

}
