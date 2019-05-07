import cl222ae_assign3.sort.SortingAlgorithms;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SortTest {

    SortingAlgorithms sg = new SortingAlgorithms();
    int[] unsorted = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] a = {}; // empty

    String[] unsort = {"c","b","a"};
    String[] sort = {"a","b","c"};


    @org.junit.jupiter.api.Test
    void insertionSort() {
        this.unsorted = sg.insertionSort(this.unsorted);


        assertNotEquals(a, sg.insertionSort(a));
        assertArrayEquals(this.unsorted, sorted);

    }

    @org.junit.jupiter.api.Test
    void mergeSort() {

        this.unsorted = sg.sort(this.unsorted);

        // Makes sure the function returns a new object.
        assertNotEquals(a, sg.insertionSort(a));
        assertArrayEquals(this.unsorted, this.sorted);

    }

    @org.junit.jupiter.api.Test
    void insertionSort1() {

        Comparator c = Comparator.naturalOrder();
        unsort = sg.insertionSort(unsort, c);

        int[] a = {};

        // Makes sure it's not the same object.
        assertNotEquals(a, sg.insertionSort(a));
        assertArrayEquals(this.unsort, this.sort);

    }

    @org.junit.jupiter.api.Test
    void mergeSort1() {

        Comparator c = Comparator.naturalOrder();
        unsort = sg.insertionSort(unsort, c);

        assertNotEquals(a, sg.insertionSort(a));
        assertArrayEquals(unsort, sort);
    }

}