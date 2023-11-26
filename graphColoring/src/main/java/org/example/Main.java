package org.example;

public class Main {
    public static void main(String[] args) {
//        Graph g1 = new Graph(5);
//        g1.addEdge(0,1);
//        g1.addEdge(0, 2);
//
//        g1.addEdge(1, 2);
//        g1.addEdge(1,3);
//
//        g1.addEdge(2,3);
//
//        g1.addEdge(3,4);
//
//        System.out.println("Colorizacion en el grafo 1: ");
//        g1.greedyColoring();


        int[][] adjacencyMatrix = {
                {0,4,5,0,0,0,0},
                {4,0,0,4,0,0,3},
                {5,0,0,0,1,0,2},
                {0,4,0,0,0,5,3},
                {0,0,1,0,0,5,2},
                {0,0,0,5,5,0,0},
                {0,3,2,3,2,0,0}
        };

        WeightedGraph graph = new WeightedGraph(adjacencyMatrix);

        System.out.println("BFS");
        graph.bfs(0);

        System.out.println("\nDFS");
        graph.dfs(0);

    }
}