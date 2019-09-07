
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    private int V;
    private LinkedList<Integer> adj[];

    TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();

        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topoSortUtil(int v, Stack<Integer> st, boolean[] visited) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topoSortUtil(i, st, visited);
            }
        }
        // a vertex will go to stack only after all its children are visited
        st.push(new Integer(v));
    }

    void topologicalSort() {
        Stack<Integer> st = new Stack<>();

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topoSortUtil(i, st, visited);

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }

    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " + "sort of the given graph");
        g.topologicalSort();
    }

}
