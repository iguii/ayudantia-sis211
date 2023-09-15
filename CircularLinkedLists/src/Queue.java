import java.util.ArrayList;

public class Queue<T> {
    private T first;

    public T getFirst() {
        first = queue.get(0);
        return first;
    }

    private ArrayList<T> queue = new ArrayList<>();

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public void insert(T data){
        queue.add(data);
    }

    public void remove(){
        queue.remove(0);
    }
}
