package org.gks.problems.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StringDeletion {

  /*
   * Given a string and a dictionary HashSet, write a function to determine the minimum number of
   * characters to delete to make a word. dictionary: [“a”, “aa”, “aaa”] , query: “abc” ,output: 2
   *
   */

  public static void main(String[] args) {
    HashSet<String> s = new HashSet<>();
    s.add("a");
    s.add("aa");
    s.add("aaa");

    String q = "abcde";
    System.out.println(getMinOp(q, s));
  }

  // abc
  // / \ \
  // ab bc ac
  // /\ /\ /\
  // a b b c a c
  public static int getMinOp(String str, HashSet<String> dict) {
    Queue<String> q = new LinkedList<>();
    Set<String> eSet = new HashSet<>();
    q.add(str);
    eSet.add(str);

    while (!q.isEmpty()) {
      String s = q.remove();
      eSet.remove(s);
      if (dict.contains(s)) {
        return str.length() - s.length();
      }
      for (int i = 0; i < s.length(); i++) {
        String substr = s.substring(0, i) + s.substring(i + 1, s.length());
        if (!eSet.contains(substr) && substr.length() > 0) {
          q.add(substr);
          eSet.add(substr);
        }
      }
    }
    return -1;
  }

}
