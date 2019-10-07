// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Gaurav_Singh3
 *
 */
public class GraphBFSDFS {
  private final HashMap<Integer, Node> nodeLookup = new HashMap<>();

  public static class Node {
    int id;
    LinkedList<Node> adjacent = new LinkedList<>();

    private Node(final int id) {
      this.id = id;
    }

    private Node getNode(final int id) {
      return this;
    }

    public void addEdge(final int source, final int destination) {
      final Node s = getNode(source);
      final Node d = getNode(destination);
      s.adjacent.add(d);
    }

    public boolean hasPathDFS(final int source, final int dest) {
      final Node s = getNode(source);
      final Node d = getNode(dest);
      final HashSet<Integer> visited = new HashSet<>();
      return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(final Node source, final Node dest, final HashSet<Integer> visited) {
      if (visited.contains(source.id))
        return false;
      visited.add(source.id);
      if (source == dest)
        return true;
      for (final Node n : source.adjacent) {
        if (hasPathDFS(n, dest, visited)) {
          return true;
        }
      }
      return false;
    }

    public boolean hasPathBFS(final Node source, final Node dest) {
      final LinkedList<Node> nextToVisit = new LinkedList<>();
      final HashSet<Integer> visited = new HashSet<>();
      nextToVisit.add(source);
      while (!nextToVisit.isEmpty()) {
        final Node n = nextToVisit.remove();
        if (n == dest)
          return true;
        if (visited.contains(n.id))
          continue;
        visited.add(n.id);
        nextToVisit.addAll(n.adjacent);
      }
      return false;
    }
  }
}
