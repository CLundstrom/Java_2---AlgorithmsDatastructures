import cl222ae_assign4.binheap.BinaryIntHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BinaryIntHeapTest.java
 *
 * @Author: Christoffer
 * @Date: 12/03/2019
 */
public class BinaryIntHeapTest {

    BinaryIntHeap test;

    @BeforeEach
    void SetUp() {
        test = new BinaryIntHeap();

    }

    @Test
    void ensureArrayCorrectSize() {

        assertTrue(test.isEmpty());
        test.insert(10);
        assertFalse(test.isEmpty());
        test.insert(15);
        assertEquals(test.pullHighest(), 15);
        assertEquals(test.pullHighest(), 10);
    }

    @Test
    void ensureResizeFunctionality() {

        int arrSize = 500;

        for (int i = 0; i < arrSize; i++) {
            test.insert(15);
        }

        for (int j = 0; j < arrSize; j++) {
            test.pullHighest();
        }

        for (int i = 0; i < arrSize; i++) {
            test.insert(15);
        }

        assertEquals(test.size(), arrSize);
        assertEquals(test.getCapacity(), 512);

    }


    @Test
    void perculateDownTest() {

        test.insert(15);
        test.insert(25);
        test.insert(34);
        test.insert(12);
        test.insert(21);
        test.insert(30);

        test.pullHighest();
        assertEquals(test.pullHighest(), 30); // next largest value
    }

    @Test
    void perculateUpAndDownTest() {

        test.insert(100);
        test.insert(124);
        test.insert(300);
        test.insert(24);
        test.insert(300);
        test.insert(125);

        assertEquals(test.pullHighest(), 300);
        assertEquals(test.pullHighest(), 300);
        assertEquals(test.pullHighest(), 125);
        assertEquals(test.pullHighest(), 124);
    }
}

