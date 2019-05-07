package cl222ae_assign4.binheap.priorityqueue;

import java.util.Iterator;

/**
 * WorkMain.java
 *
 * @Author: Christoffer
 * @Date: 13/03/2019
 */
public class WorkMain {

    private static BinaryHeapQueue bp = new BinaryHeapQueue(8);


    public static void main(String[] args) {

        /*Task task1 = new WorkTask("Eat", Priority.MEDIUM);
        Task task2 = new WorkTask("Sleep", Priority.LOW);
        Task task3 = new WorkTask("Hygiene", Priority.LOW);
        Task task4 = new WorkTask("Browse memes", Priority.HIGH);
        Task task5 = new WorkTask("Study", Priority.URGENT);*/

        Task task1 = new WorkTask("Eat", 5);
        Task task2 = new WorkTask("Sleep", 1);
        Task task3 = new WorkTask("Hygiene", 1);
        Task task4 = new WorkTask("Browse memes", 14);
        Task task5 = new WorkTask("Study", 15);



        /*for(int i=0; i < 100; i++){
            bp.insert(new WorkTask("Eat", Priority.MEDIUM));
        }*/
        bp.insert(task1);
        bp.insert(task2);
        bp.insert(task3);
        bp.insert(task4);
        bp.insert(task5);

        Iterator<Task> it = bp.iterator();

        while(it.hasNext()){
            System.out.println(bp.pullHighest());
        }
    }
}

