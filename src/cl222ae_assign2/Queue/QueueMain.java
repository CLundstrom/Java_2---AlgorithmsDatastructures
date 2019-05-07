package cl222ae_assign2.Queue;

import java.util.Iterator;


/**
 * Class demonstrating the functionality of LinkedQueue.java
 */
public class QueueMain {

    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue().toString());
        System.out.println(queue.dequeue().toString());


        Iterator<Object> it = queue.iterator();
        System.out.println("\nLeft in queue: ");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        System.out.println("First: " + queue.first());
        System.out.println("Last: " + queue.last());
        System.out.println("Empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());

        System.out.println("\n" + queue.toString());


    }


}
