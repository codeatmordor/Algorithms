

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.graph;

// Cycles of length n in an undirected and connected graph

/*
 * To solve this Problem, DFS(Depth First Search) can be effectively used. Using DFS we find every
 * possible path of length (n-1) for a particular source (or starting point). Then we check if this
 * path ends with the vertex it started with, if yes then we count this as the cycle of length n.
 * Notice that we looked for path of length (n-1) because the nth edge will be the closing edge of
 * cycle.
 */
public class NLengthCycle {

  // Number of vertices
  public static final int V = 5;
  static int count = 0;

  static void DFS(int graph[][], boolean visited[], int n, int vert, int start) {

    // mark the vertex vert as visited
    visited[vert] = true;

    // if the path of length (n-1) is found
    if (n == 0) {

      // mark vert as un-visited to
      // make it usable again
      visited[vert] = false;

      // Check if vertex vert end
      // with vertex start
      if (graph[vert][start] == 1) {
        count++;
        return;
      } else
        return;
    }

    // For searching every possible
    // path of length (n-1)
    for (int i = 0; i < V; i++)
      if (!visited[i] && graph[vert][i] == 1)

        // DFS for searching path by
        // decreasing length by 1
        DFS(graph, visited, n - 1, i, start);

    // marking vert as unvisited to make it
    // usable again
    visited[vert] = false;
  }

  // Count cycles of length N in an
  // undirected and connected graph.
  static int countCycles(int graph[][], int n) {

    // all vertex are marked un-visited
    // initially.
    boolean visited[] = new boolean[V];

    // Searching for cycle by using
    // v-n+1 vertices
    for (int i = 0; i < V - (n - 1); i++) {
      DFS(graph, visited, n - 1, i, i);

      // ith vertex is marked as visited
      // and will not be visited again
      visited[i] = true;
    }

    return count / 2;
  }

  public static void main(String[] args) {
    int graph[][] =
        {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}};
  }

}

