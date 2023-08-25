import java.util.Iterator;

public class Lista<T> implements Iterable<T>{
    T[] data;
    int size;
    static int DEFAULT_SIZE = 1000;

    public Lista() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
    }

    public Lista(T[] data) {
        this.data = data;
    }

    public Lista(T[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public void add(T element) {
        this.data[this.size++] = element;
    }

    public T get(int index) {
        return this.data[index];
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.size--;
    }

    public void insert(T element, int index) {
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = element;
        this.size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
