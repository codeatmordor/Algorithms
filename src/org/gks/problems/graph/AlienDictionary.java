

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

  public static String findOrder(String[] words) {
    if (words == null || words.length == 0)
      return "";

    // Initialize Graph
    Map<Character, Integer> inDeg = new HashMap<>();
    Map<Character, List<Character>> graph = new HashMap<>();
    for (String word : words) {
      for (Character c : word.toCharArray()) {
        inDeg.put(c, 0);
        graph.put(c, new ArrayList<Character>());
      }
    }

    // Lets build the graph

    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];
      for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
        Character parent = w1.charAt(j);
        Character child = w2.charAt(j);
        if (!parent.equals(child)) {
          graph.get(parent).add(child);
          inDeg.put(child, inDeg.get(child) + 1);
          break;// only the first different character between the two words will help us find the
                // order
        }
      }
    }

    // Find All sources, all vertices with 0 indegree
    Queue<Character> sources = new LinkedList<>();
    for (Map.Entry<Character, Integer> e : inDeg.entrySet()) {
      if (e.getValue() == 0) {
        sources.add(e.getKey());
      }
    }

    StringBuilder sortedOrder = new StringBuilder();

    // For each source, add it to the sortedOrder and subtract one from all of its children's
    // in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    while (!sources.isEmpty()) {
      Character source = sources.poll();
      sortedOrder.append(source);
      List<Character> children = graph.get(source);
      for (Character child : children) {
        Integer deg = inDeg.get(child);
        inDeg.put(child, deg - 1);
        if (inDeg.get(child) == 0)
          sources.add(child);
      }
    }
    // if sortedOrder doesn't contain all characters, there is a cyclic dependency between
    // characters, therefore, we
    // will not be able to find the correct ordering of the characters
    if (sortedOrder.length() != inDeg.size())
      return "";

    return sortedOrder.toString();
  }

  public static void main(String[] args) {
    String result = AlienDictionary.findOrder(new String[] {"ba", "bc", "ac", "cab"});
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] {"cab", "aaa", "aab"});
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] {"ywx", "xww", "xz", "zyy", "zwz"});
    System.out.println("Character order: " + result);
  }
}

