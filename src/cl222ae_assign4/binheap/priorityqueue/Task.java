package cl222ae_assign4.binheap.priorityqueue;

/**
 * Task.java
 *
 * @Author: Christoffer
 * @Date: 13/03/2019
 */
public interface Task {


    //### DEPRECATED
    //Priority getPriority();
    //void setPriority(Priority p);

    int getPriority();

    void setPriority(int p);
    void setComplete();
    Status isCompleted();

}
