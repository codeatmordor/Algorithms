

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * This is how we can implement this algorithm:
 *
 * a. Initialization
 *
 * We will store the graph in Adjacency Lists, which means each parent vertex will have a list
 * containing all of its children. We will do this using a HashMap where the ‘key’ will be the
 * parent vertex number and the value will be a List containing children vertices. To find the
 * sources, we will keep a HashMap to count the in-degrees i.e., count of incoming edges of each
 * vertex. Any vertex with ‘0’ in-degree will be a source. b. Build the graph and find in-degrees of
 * all vertices
 *
 * We will build the graph from the input and populate the in-degrees HashMap. c. Find all sources
 *
 * All vertices with ‘0’ in-degrees will be our sources and we will store them in a Queue. d. Sort
 *
 * For each source, do the following things: Add it to the sorted list. Get all of its children from
 * the graph. Decrement the in-degree of each child by 1. If a child’s in-degree becomes ‘0’, add it
 * to the sources Queue. Repeat step 1, until the source Queue is empty.
 */


public class TopologicalSortAll {

  static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sorted = new ArrayList<>();
    if (vertices <= 0) {
      return sorted;
    }

    // Initialize the graph
    HashMap<Integer, Integer> indeg = new HashMap<>();
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < vertices; i++) {
      indeg.put(i, 0);
      graph.put(i, new ArrayList<Integer>());
    }

    // Build the graph
    for (int i = 0; i < edges.length; i++) {
      int parent = edges[i][0];
      int child = edges[i][1];
      graph.get(parent).add(child);
      indeg.put(child, indeg.get(child) + 1);
    }

    // Find all sources, all vertices with 0 indegree
    Queue<Integer> sources = new LinkedList<>();
    for (Map.Entry<Integer, Integer> e : indeg.entrySet()) {
      if (e.getValue() == 0) {
        sources.add(e.getKey());
      }
    }

    /*
     * For each source, add it to the sortedOrder and subtract one from all of its children's
     * in-degrees, if a child's in-degree becomes zero, add it to the sources queue
     */

    while (!sources.isEmpty()) {
      Integer source = sources.poll();
      sorted.add(source);
      List<Integer> children = graph.get(source);
      for (Integer child : children) {
        indeg.put(child, indeg.get(child) - 1);
        if (indeg.get(child) == 0) {
          sources.add(child);
        }
      }
    }
    System.out.println(sorted);
    // topological sort is not possible as the graph has a cycle
    if (sorted.size() != vertices)
      return new ArrayList<>();
    return sorted;
  }

  public static void main(String[] args) {
    List<Integer> gr = TopologicalSortAll.sort(4, new int[][] {new int[] {3, 2}, new int[] {3, 0},
        new int[] {2, 0}, new int[] {2, 1}, new int[] {1, 0}, new int[] {0, 2}});

    System.out.println(gr);

  }



}

