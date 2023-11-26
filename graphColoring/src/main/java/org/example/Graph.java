package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void greedyColoring(){
        int result[] = new int[V];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean available[] = new boolean[V];
        Arrays.fill(available, true);

        for(int u=1; u<V; u++){
            Iterator<Integer> it = adj[u].iterator();
            while(it.hasNext()){
                int i = it.next();
                if(result[i] != -1) available[result[i]] = false;
            }
            int cr;
            for(cr = 0; cr<V; cr++){
                if(available[cr]) break;
            }
            result[u] = cr;
            Arrays.fill(available, true);
        }

        for(int u=0; u<V; u++){
            System.out.println("Vertice " + u + " --> Color " + result[u]);
        }
    }
}
