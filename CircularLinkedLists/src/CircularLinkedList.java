/**
 * Clase CircularLinkedList que contiene los metodos para crear una lista enlazada.
 * @param <T> es el tipo de dato que va a contener la lista.
 */
public class CircularLinkedList<T> {
    Node head; // Creamos un nodo "head" que apunta al primer elemento de la lista.
    Node tail;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    } // constructor para crear una lista vacia, por eso head es null.


    public static class Node<T> { // creamos una subclase Node, que es la que contiene los datos y el puntero al siguiente nodo.
        T data; // T es el tipo de dato que va a contener el nodo.


        Node next; // puntero al siguiente nodo.

        public Node(T data) { // constructor de la subclase Node que recibe el dato que va a contener el nodo.
            this.data = data;
            this.next = null; // el puntero al siguiente nodo se inicializa en null.
        }
    }


    /**
     * Metodo para agregar un nodo al final de la lista.
     * @param data es el dato que va a contener el nodo.
     */
    public void append(T data) { // metodo para agregar un nodo al final de la lista.
        Node newNode = new Node(data); // creamos un nuevo nodo con el dato que recibimos como parametro.
        if (head == null) { // si la lista esta vacia, el nuevo nodo es el head.
            head = newNode;
        } else { // si la lista no esta vacia, recorremos la lista hasta llegar al ultimo nodo y agregamos el nuevo nodo al final.
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    /**
     * Metodo para agregar un nodo al inicio de la lista.
     * @param data es el dato que va a contener el nodo.
     */
    public void prepend(T data) { // metodo para agregar un nodo al inicio de la lista.
        Node newNode = new Node(data); // creamos un nuevo nodo con el dato que recibimos como parametro.
        newNode.next = head; // el puntero del nuevo nodo apunta al head.
        head = newNode; // el nuevo nodo es el head.
    }

    /**
     * Metodo para agregar un nodo en una posicion especifica de la lista.
     * @param data es el dato que va a contener el nodo.
     * @param index es la posicion en la que se va a agregar el nodo.
     */

//    public void append(T data){
//        Node newNode = new Node(data);
//
//        Node current = head;
//        if(head == null){
//            head = current;
//            tail = current;
//            return;
//        }
//
//        while(current.next != tail){
//            current = current.next;
//        }
//        current.next = newNode;
//        tail = newNode;
//    }
//
//    public void append(T data){
//        Node newNode = new Node(data);
//
//        tail.next = newNode;
//        newNode.next = head;
//    }
    public void insert(T data, int index) { // metodo para agregar un nodo en una posicion especifica de la lista.
        Node newNode = new Node(data); // creamos un nuevo nodo con el dato que recibimos como parametro.
        if (index == 0) { // si la posicion es 0, el nuevo nodo es el head.
            newNode.next = head;
            head = newNode;
        } else { // si la posicion no es 0, recorremos la lista hasta llegar a la posicion anterior a la que queremos agregar el nuevo nodo.
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next; // el puntero del nuevo nodo apunta al siguiente nodo.
            temp.next = newNode; // el puntero del nodo anterior al nuevo nodo apunta al nuevo nodo.
        }
    }

    /**
     * Metodo para eliminar un nodo de la lista.
     * @param index es la posicion del nodo que se va a eliminar.
     */
    public void delete(int index) { // metodo para eliminar un nodo de la lista.
        if (index == 0) { // si la posicion es 0, el head apunta al siguiente nodo.
            head = head.next;
        } else { // si la posicion no es 0, recorremos la lista hasta llegar a la posicion anterior a la que queremos eliminar.
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next; // el puntero del nodo anterior al nodo que queremos eliminar apunta al nodo siguiente al nodo que queremos eliminar.
        }
    }

    /**
     * Metodo para imprimir la lista.
     */
    public void printList() { // metodo para imprimir la lista.
        Node temp = head;
        while (temp != null) { // recorremos la lista e imprimimos el dato de cada nodo.
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Metodo para obtener el tamaño de la lista.
     * @return el tamaño de la lista.
     */
    public int size() { // metodo para obtener el tamaño de la lista.
        int size = 0;
        Node temp = head;
        while (temp != null) { // recorremos la lista y aumentamos el tamaño por cada nodo que recorremos.
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * Metodo para obtener el dato de un nodo de la lista.
     * @param index es la posicion del nodo del que se quiere obtener el dato.
     * @return el dato del nodo.
     */
    public T get(int index) { // metodo para obtener el dato de un nodo de la lista.
        Node temp = head;
        for (int i = 0; i < index; i++) { // recorremos la lista hasta llegar a la posicion del nodo del que queremos obtener el dato.
            temp = temp.next;
        }
        return (T) temp.data;
    }
}
