package cl222ae_assign2.Queue;

import java.util.Iterator;


/**
 * ArrayQueueMain.java
 *
 * @Author: Christoffer Lundström
 * @Date: 13/02/19
 * <p>
 * Showing the functionality of an Array Queue.
 */
public class ArrayQueueMain {


    public static void main(String[] args) {
        ArrayQueue arr = new ArrayQueue();

        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(3);
        arr.enqueue(4);
        arr.enqueue(5);
        arr.enqueue(6);
        arr.enqueue(7);
        arr.enqueue(8);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);


        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());
        System.out.println(arr.dequeue());

        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);
        arr.enqueue(9);


        // try to iterate empty list. -> throws
        Iterator<Object> it = arr.iterator();

        while (it.hasNext()) {
            it.next();
            arr.dequeue();
        }
    }
}
