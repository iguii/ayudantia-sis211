package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V; // vertices/nodes
    private LinkedList<Integer> adj[]; // lista de adyacencia

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v,int w){ // adds edge connection to adjacency list
        adj[v].add(w);
        adj[w].add(v);
    }

    void greedyColoring(){
        int result[] = new int[V]; // crear array de los vertices

        Arrays.fill(result, -1);

        result[0] = 0; // 0 -1 -1 -1 -1

        boolean available[] = new boolean[V];
        Arrays.fill(available, true); // true, true, true, true, true

        for(int u=1; u<V; u++){
            Iterator<Integer> it = adj[u].iterator(); // para cada conexion en cada u-nesimo nodo
            while(it.hasNext()){
                int i = it.next();
                if(result[i] != -1) available[result[i]] = false;
            }

            int cr;
            for(cr = 0; cr < V; cr++){
                if(available[cr]) break;
                System.out.println(cr);
            }

            result[u] = cr;

            Arrays.fill(available, true);
        }
        for(int u = 0; u<V; u++){
            System.out.println("Vertice " + u + "--> Color " + result[u]);
        }
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(2,3);
        g1.addEdge(3,4);
        System.out.println("Coloring on graph 1");
        g1.greedyColoring();
    }
}
