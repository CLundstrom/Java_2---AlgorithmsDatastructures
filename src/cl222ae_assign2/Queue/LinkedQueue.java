package cl222ae_assign2.Queue;

import java.util.Iterator;

/**
 * LinkedQueue.java
 *
 * @Author: Christoffer Lundstrom
 * @Date: 13/02/19
 * <p>
 * A linked queue using the head & tail approach.
 */
public class LinkedQueue implements Queue {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private class Node {

        Object value;
        Node next = null; // reference to next node

        Node(Object v) {
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
    public void enqueue(Object element) {
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
    public Object dequeue() {
        if (head == null) throw new NullPointerException("No objects in queue.");
        Node tmp = head;
        head = head.next;
        size--;
        return tmp;
    }

    /**
     * Returns first object in queue.
     */
    @Override
    public Object first() {
        if (head == null) throw new NullPointerException("No objects in queue.");
        return head;
    }

    /**
     * Returns last object in queue.
     */
    @Override
    public Object last() {
        if (head == null) throw new NullPointerException("No objects in queue.");
        return tail;
    }

    /**
     * Returns string representation of the contents in the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        Iterator<Object> it = iterator();

        while (it.hasNext()) {
            sb.append(it.next() + ", ");
        }

        return sb.toString();

    }

    /**
     * Returns an iterator capable of iterating over objects in the queue.
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            // Assign index to first Node.
            Node index = head;

            @Override
            public Object next() {
                if (hasNext()) {
                    // return current value and set index to next.
                    Node currentNode = index;
                    index = index.next;
                    return currentNode;
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
