package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int M = 5, N= 7; // M = filas, N = columnas

//        char[][] m = new char[M][N];

        char[][] m = { // S = start, E = end, # = obstaculo, . = camino
                {'S', '.', '.', '#', '.', '.', '.'},
                {'.', '#', '.', '.', '.', '#', '.'},
                {'.', '#', '.', '.', '.', '.', '.'},
                {'.', '.', '#', '#', '.', '.', '.'},
                {'#', '.', '#', 'E', '.', '#', '.'},
        };

        int startX = 0, startY = 0; //posicion inicial (donde se encuentra la S)

        int[] dx = {-1, +1, 0 ,0}; // vector de movimientos en x
        int[] dy = {0, 0, +1, -1}; // vector de movimientos en y

        Queue<Integer> xQueue = new LinkedList<>(); // Frontier para X
        Queue<Integer> yQueue = new LinkedList<>(); // Frontier para Y

        int moveCount = 0; // Cantidad de movimientos realizados
        int nodesLeftInLayer = 1; // Cantidad de nodos en la capa actual
        int nodesInNextLayer = 0; // Cantidad de nodos en la siguiente capa

        boolean[][] visited = new boolean[M][N]; // matriz de visitados

        //BFS

        // se agrega el nodo inicial a la cola
        xQueue.add(startX);
        yQueue.add(startY);

        // se marca el nodo inicial como visitado
        visited[startX][startY] = true;

        // mientras la cola no este vacia
        while(xQueue.size() > 0){ // ya que xQueue.size() == yQueue.size() se puede usar cualquiera de las dos

            // se obtiene el nodo actual para cada coordenada
            int x = xQueue.poll();
            int y = yQueue.poll();

            // si el nodo actual es el final
            if(m[x][y] == 'E'){
                System.out.println("Se llego al final");
                System.out.println("Se hicieron " + moveCount + " movimientos");
                System.out.println("El final del laberinto esta en  x=" + x + " y=" + y);
//                System.out.println("Se visitaron " + nodesInNextLayer + " nodos");
//                System.out.println("Se quedaron " + (xQueue.size() + yQueue.size()) + " nodos en la cola");
//                System.out.println("Se visitaron " + (M*N - (xQueue.size() + yQueue.size())) + " nodos");
                break;
            }

            // se recorren los nodos adyacentes con los vectores de dirección
            for(int i = 0; i< 4; i++){

                // se obtienen las coordenadas del nodo adyacente
                int newX = x + dx[i];
                int newY = y + dy[i];

                // se verifica que el nodo adyacente este dentro de la matriz
                if (newX < 0 || newY < 0) continue;
                if (newX >= M || newY >= N) continue;

                // se verifica que el nodo adyacente no haya sido visitado y que no sea un obstaculo
                if(visited[newX][newY]) continue;
                if(m[newX][newY] == '#') continue;

                // Si ninguna de estas condiciones se cumple
                // se agrega el nodo adyacente a la cola
                xQueue.add(newX);
                yQueue.add(newY);

                // se marca el nodo adyacente como visitado
                visited[newX][newY] = true;

                // se aumenta la cantidad de nodos en la siguiente capa
                nodesInNextLayer++;
            }

            // quitamos el nodo para cada coordenada de la cola
            nodesLeftInLayer--;

            // verificamos si ya se recorrieron todos los nodos de la capa actual,
            // si estos se recorrieron, se aumenta la cantidad de movimientos
            // y se cambia la cantidad de nodos en la capa actual por la cantidad de nodos en la siguiente capa
            if(nodesLeftInLayer == 0){
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }

        }
    }
}