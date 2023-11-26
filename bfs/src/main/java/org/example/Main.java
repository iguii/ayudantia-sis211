package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int M = 5, N = 7;
        char[][] m = {
                {'S', '.', '.', '#', '.', '.', '.'},
                {'.', '#', '.', '.', '.', '#', '.'},
                {'.', '#', '.', '.', '.', '.', '.'},
                {'.', '.', '#', '#', '.', '.', '.'},
                {'#', '.', '#', 'E', '.', '#', '.'},
        };

        int startX = 0, startY = 0;

        int[] dx = {-1, 1, 0,0};
        int[] dy = {0, 0, -1, 1};

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        int moveCount = 0;
        int nodeLeftInLayer = 1;
        int nodeInNextLayer = 0;

        boolean[][] visited = new boolean[M][N];

        // BFS
        xQueue.add(startX);
        yQueue.add(startY);
        visited[startX][startY] = true;

        while(xQueue.size() > 0){
            int x = xQueue.poll();
            int y = yQueue.poll();

            if(m[x][y]=='E'){ //TODO: termino el programa
                System.out.println("se llego al final");
                System.out.println("Se hicieron " + moveCount + " pasos.");
                System.out.println("El final del laberinto esta en x=" + x + " y="+ y);
                break;
            }

            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= M || newY >= N) continue;
                if (newX < 0 || newY < 0) continue;

                if(visited[newX][newY])continue;
                if(m[newX][newY] == '#') continue;

                xQueue.add(newX);
                yQueue.add(newY);
                visited[newX][newY] = true;

                nodeInNextLayer++;
            }
            nodeLeftInLayer--;

            if(nodeLeftInLayer == 0){
                nodeLeftInLayer = nodeInNextLayer;
                nodeInNextLayer = 0;
                moveCount++;
            }

        }






    }
}