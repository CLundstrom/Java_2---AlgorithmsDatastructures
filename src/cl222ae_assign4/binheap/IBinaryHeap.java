package cl222ae_assign4.binheap;

public interface IBinaryHeap {

    void BinaryIntHeap();   // Constructs an empty heap
    void insert(int n); // Add n to heap
    int pullHighest();    // Return and remove element with highest priority
    int size();         // Current heap size
    boolean isEmpty(); // True if heap is empty
}
