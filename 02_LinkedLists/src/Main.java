public class Main {
    public static void main(String[] args) {
        /*
        * OTROS EJEMPLOS DE LINKED LIST
        *
        * LinkedList<Double> list = new LinkedList<>(); // -> para manejar una lista de numeros decimales.
        * LinkedList<String> list = new LinkedList<>(); // -> para manejar una lista de cadenas de texto.
        * LinkedList<Character> list = new LinkedList<>(); // -> para manejar una lista de caracteres.
        * LinkedList<Boolean> list = new LinkedList<>(); // -> para manejar una lista de valores booleanos.
        * LinkedList<LinkedList> list = new LinkedList<>(); // -> para manejar una lista de listas.
        * LinkedList<LinkedList<Integer>> list = new LinkedList<>(); // -> para manejar una lista de listas de numeros enteros.
        *
        * */


        LinkedList<Integer> list = new LinkedList<>();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        list.prepend(0);

        list.insert(6, 6);

        list.delete(3);

        list.printList();

        System.out.println("El tamaño de la lista es: " + list.size());

        System.out.println("El elemento en la posicion 3 es: " + list.get(3));
    }
}