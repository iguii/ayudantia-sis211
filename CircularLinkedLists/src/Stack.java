import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack = new ArrayList<>();

    private T top;

    public T getTop() {
        top = stack.get(stack.size() -1);
        return top;
    }

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void insert(T data){
        stack.add(data);
    }

    public int size(){
        return stack.size();
    }

    public void remove(){
        stack.remove(stack.size() -1);
    }

    @Override
    public String toString() {
        String output = "";
        for(T element : stack){
            output += element + ", ";
        }
        return output;
    }
}
