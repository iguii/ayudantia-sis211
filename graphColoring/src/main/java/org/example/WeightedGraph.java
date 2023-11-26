package org.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WeightedGraph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public WeightedGraph(int[][] adjacencyMatrix) {
        this.vertices = adjacencyMatrix.length;
        this.adjacencyMatrix = new int[vertices][vertices];
        for(int i =0; i<vertices; i++){
            System.arraycopy(adjacencyMatrix[i], 0, this.adjacencyMatrix[i], 0, vertices);
        }
    }

    void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for(int neighbor = 0; neighbor < vertices; neighbor++){
                if(adjacencyMatrix[current][neighbor] > 0 && !visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }


    void dfs(int start){
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int current, Set<Integer> visited){
        System.out.print(current + " ");
        visited.add(current);

        for(int neighbor = 0; neighbor < vertices; neighbor++){
            if(adjacencyMatrix[current][neighbor] > 0 && !visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }
}
