package cl222ae_assign4.binheap.priorityqueue;

/**
 * WorkTask.java
 *
 * @Author: Christoffer
 * @Date: 13/03/2019
 * <p>
 *
 * Note: Would rather use an enum for Priority because it seems more intuitive than using an integer.
 * However, the assignment required a positive integer so i'm deprecating the Priority enum.
 */
public class WorkTask implements Task {

    //private Priority priority = Priority.MEDIUM; // default prio
    private int priority = 0;
    private String desc = "";
    private Status status = Status.NotComplete;


    WorkTask(String desc, int p){
        if(priority < 0) this.priority = 0;
        else{
            this.desc = desc;
            this.priority = p;
        }
    }

    void setDescription(String s){
        this.desc = s;
    }

    @Override
    public String toString(){
        return desc;
    }
    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if(priority < 0) {
            this.priority = 0;
        }
        else {
            this.priority = priority;
        }
    }

    @Override
    public void setComplete() {
        this.status = Status.Complete;
    }

    @Override
    public Status isCompleted() {
        return status;
    }


}
