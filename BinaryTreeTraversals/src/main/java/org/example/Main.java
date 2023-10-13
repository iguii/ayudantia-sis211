package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void dfs(Node<Character> root) {
        Stack<Node<Character>> frontier = new Stack<>(); // creamos la frontera para controlar los nodos visitados
        frontier.push(root); // colocamos el root dentro de la frontera
        while(!frontier.empty()){ // equivalente a: frontier.empty() == true
            Node<Character> currentNode = frontier.pop(); // eliminamos al nodo de la pila y lo asignamos a currentNode
            System.out.print(currentNode.value + ", ");
            if(currentNode.right != null)  frontier.push(currentNode.right); // reconocemos al hijo de la DERECHA y lo colocamos en la frontera
            if(currentNode.left != null) frontier.push(currentNode.left); // reconocemos al hijo de la IZQUIERDR y lo colocamos en la frontera
        }
    }

    public static ArrayList<Character> recursiveDfs(Node<Character> root){
        ArrayList<Character> result = new ArrayList<>(); // creamos el arraylist para almacenar los nodos visitados
        if(root == null) return result; // Caso base: en el caso de ser un arbol binario vacio, retornar el arraylist creado
        result.add(root.value); // añadimos el valor del nodo actual a result
        result.addAll(recursiveDfs(root.left)); // iniciamos la llamada recursiva para todos los hijos de la DERECHA y añadimos todos los valores de la llamada a resulta
        result.addAll(recursiveDfs(root.right)); // iniciamos la llamada recursiva para todos los hijos de la IZQUIERDA y añadimos todos los valores de la llamada a resulta
        return result;
    }

    public static void preOrder(Node<Character> root){
        if(root == null) return;
        System.out.print(root.value + ", "); // en Preorder esto va al inicio
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node<Character> root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value + ", "); // en InOrder esto va al medio
        inOrder(root.right);
    }

    public static void postOrder(Node<Character> root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + ", "); // en PostOrder esto va al final
    }



    public static void main(String[] args) {
        /*
        *           A
        *         /   \
        *        B     C
        *       /     / \
        *      D     E   F
        *           / \
        *          G   H
        * */

        Node<Character> root = new Node<>('A');
        root.left = new Node<>('B');
        root.right = new Node<>('C');
        root.left.left = new Node<>('D');
        root.right.left = new Node<>('E');
        root.right.right = new Node<>('F');
        root.right.left.left = new Node<>('G');
        root.right.left.right = new Node<>('H');


        System.out.println("Recorrido de arboles binarios: ");
        System.out.println("InOrder");
        inOrder(root);
        System.out.println("\nPreOrder");
        preOrder(root);
        System.out.println("\nPostOrder");
        postOrder(root);

        System.out.println("\n\n\nBusqueda por profundidad (DFS)");
        System.out.println("DFS iterativo:");
        dfs(root);
        System.out.println("\nDFS recursivo:");
        System.out.println(recursiveDfs(root));

    }
}