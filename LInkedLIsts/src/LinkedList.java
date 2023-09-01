public class LinkedList<T> {
    Node head;


    public LinkedList(){
        this.head = null;
    }

    public class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


    /*
    * Returns the n-th element of the linked list
    * @returns
    * */
    public T get(int index) {
        if(head == null){
            return null;
        }
        Node aux = head;
        for(int i =0; i<index; i++){
            aux = aux.next;
        }
        return (T) aux;
    }


    public void insert(T data){
        Node<T> newInsertedNode = new Node<>(data);

        if (head == null){
            head = newInsertedNode;
            return;
        }

        Node aux = head;
        while(aux.next != null){
            aux = aux.next;
        }
        aux.next = newInsertedNode;
        return;
    }


}
