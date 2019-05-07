import cl222ae_assign4.queue.LinkedQueue;
import cl222ae_assign4.queue.Queue;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;



/**
 * LinkedQueueTest.java
 *
 * @Author: Christoffer
 * @Date: 11/03/2019
 * <p>
 * Unit test for two different type of queues.
 */

class LinkedQueueTest {

    // Tests both classes at the same time.
    Queue[] queueTests = {new LinkedQueue<Integer>(), new LinkedQueue<String>()};


    @Test
    void returnCorrectTypeTest(){
        LinkedQueue<Integer> lq = new LinkedQueue<>();
        LinkedQueue<Double> ls = new LinkedQueue<>();
        ls.enqueue(5.0);
        lq.enqueue(200);

        int a = lq.dequeue();
        double b = ls.dequeue();
        assertTrue((Integer)a instanceof Integer);
        assertTrue((Double)b instanceof Double);
    }


    @Test
    void size() {
        int testSize = 2500000; // try extreme queue-sizes

        for (Queue q : queueTests) {

            for (int i = 0; i < testSize; i++) {
                q.enqueue(1);
                q.enqueue("Test");
                assertEquals(i*2 + 2, q.size());
            }
        }
    }

    @Test
    void isEmpty() {
        for (Queue q : queueTests) {

            q.enqueue(2);
            q.enqueue(2);
            q.enqueue("Test");
            assertFalse(q.isEmpty());
            q.dequeue();
            q.dequeue();
            q.dequeue();
            assertTrue(q.isEmpty());

        }

    }

    @Test
    void enqueue() {
        for (Queue q : queueTests) {
            for (int i = 0; i < 100; i++) {
                q.enqueue(1); //int
                q.enqueue("String"); //string
                q.enqueue(new int[10]); //array
            }

            for (int i = 0; i < 300; i++) {
                q.dequeue();
            }
            assertEquals(0, q.size()); // check size after enqueue, dequeue
        }
    }

    @Test
    void dequeue() {

        //enqueue 25 elements
        for (Queue q : queueTests) {
            for (int i = 0; i < 25; i++) {
                q.enqueue(1);
                q.enqueue("Test");
            }
            Iterator it = q.iterator();

            // iterate & dequeue
            while (it.hasNext()) {
                it.next();
                q.dequeue();

            }
            assertEquals(0, q.size()); // size after dequeue
            assertFalse(it.hasNext()); // check empty iterator

            //look for RunTimeException because Array throws IndexOutOfBounds and Linked throws NullPointer.
            assertThrows(RuntimeException.class, () -> q.first());

        }
    }

    @Test
    void first() {
        // empty
        for (Queue q : queueTests) {
            assertThrows(RuntimeException.class, () -> q.first());
        }

    }

    @Test
    void last() {
        //empty
        for (Queue q : queueTests) {
            q.enqueue(1);
            q.dequeue();
            assertThrows(RuntimeException.class, () -> q.last());
        }

    }

    @Test
    void iterator() {
        for (Queue q : queueTests) {

            Iterator<Object> it = q.iterator();

            assertFalse(it.hasNext());
            assertThrows(RuntimeException.class, () -> it.next());
        }

    }
}