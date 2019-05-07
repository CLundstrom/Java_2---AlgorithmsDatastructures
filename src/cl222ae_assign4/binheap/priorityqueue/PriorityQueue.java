package cl222ae_assign4.binheap.priorityqueue;


/**
 * priorityqueue.java
 *
 * @Author: Christoffer
 * @Date: 13/03/2019
 */
public interface PriorityQueue {

    int getCapacity();

    void insert(Task t);

    Object pullHighest();

    int size();

    boolean isEmpty();

    boolean contains(Task t);
}
