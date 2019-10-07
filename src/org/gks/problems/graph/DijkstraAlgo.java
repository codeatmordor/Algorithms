package org.gks.problems.graph;

class DijkstraAlgo {

  public static final int V = 9;

  int minDistance(int dist[], boolean[] shortestPathTreeSet) {
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < V; v++)
      if (shortestPathTreeSet[v] == false && dist[v] <= min) {
        min = dist[v];
        min_index = v;
      }

    return min_index;
  }

  public void dijkstra(int[][] ggraph, int s) {
    int[] dist = new int[V];

    boolean[] shortestPathTreeSet = new boolean[V];

    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
      shortestPathTreeSet[i] = false;
    }
    // distance from itself is always zero
    dist[s] = 0;

    for (int c = 0; c < V - 1; c++) {
      int u = minDistance(dist, shortestPathTreeSet);
      // Mark the picked vertex as processed
      shortestPathTreeSet[u] = true;
      for (int v = 0; v < V; v++) {
        if (!shortestPathTreeSet[v] && ggraph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
            && dist[u] + ggraph[u][v] < dist[v])
          dist[v] = dist[u] + ggraph[u][v];
      }
    }

    printSolution(dist);
  }

  void printSolution(int dist[]) {
    System.out.println("Vertex \t\t Distance from Source");
    for (int i = 0; i < V; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }

  public static void main(String[] args) {
    int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 6}, {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    DijkstraAlgo t = new DijkstraAlgo();
    t.dijkstra(graph, 0);
  }

}
