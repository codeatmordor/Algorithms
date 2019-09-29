

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TaskScheduling {

  static boolean isSchedulingPossible(int tasks, int[][] preReq) {
    List<Integer> ordered = new ArrayList<>();
    if (tasks <= 0)
      return true;

    HashMap<Integer, Integer> inDeg = new HashMap<>();
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < tasks; i++) {
      inDeg.put(i, 0);
      graph.put(i, new ArrayList<>());
    }

    for (int i = 0; i < preReq.length; i++) {
      int parent = preReq[i][0];
      int child = preReq[i][1];
      inDeg.put(child, inDeg.get(child) + 1);
      graph.get(parent).add(child);
    }

    Queue<Integer> sources = new LinkedList<>();
    for (Map.Entry<Integer, Integer> e : inDeg.entrySet()) {
      if (e.getValue() == 0) {
        sources.add(e.getKey());
      }
    }

    while (!sources.isEmpty()) {
      Integer source = sources.poll();
      ordered.add(source);
      List<Integer> children = graph.get(source);
      for (Integer child : children) {
        inDeg.put(child, inDeg.get(child) - 1);
        if (inDeg.get(child) == 0) {
          sources.add(child);
        }
      }
    }

    return ordered.size() == tasks;

  }

  public static void main(String[] args) {
    int[][] taskPreReq = new int[][] {new int[] {0, 1}, new int[] {1, 2}};
    System.out.println(TaskScheduling.isSchedulingPossible(3, taskPreReq));

    System.out.println(TaskScheduling.isSchedulingPossible(6, new int[][] {new int[] {2, 5},
        new int[] {0, 5}, new int[] {0, 4}, new int[] {1, 4}, new int[] {3, 2}, new int[] {1, 3}}));
  }
}

