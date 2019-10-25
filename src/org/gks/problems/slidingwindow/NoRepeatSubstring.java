package org.gks.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

  public static int findLength(final String str) {
    int start = 0;
    int end = 0;
    int len = 0;

    // Map to keep indexes of charactes
    final Map<Character, Integer> mf = new HashMap<>();
    for (end = 0; end < str.length(); end++) {
      final Character c = str.charAt(end);

      // if the map already contains the 'c', shrink the window from the beginning so that
      // we have only one occurrence of 'c'
      if (mf.containsKey(c)) {
        // this is tricky; in the current window, we will not have any 'c' after its
        // previous index
        // and if 'windowStart' is already ahead of the last index of 'c', we'll keep
        // 'windowStart'
        start = Math.max(start, mf.get(c) + 1);
      }
      mf.put(c, end);
      len = Math.max(len, end - start + 1);
    }
    return len;
  }

  /**
   * @param args
   */
  public static void main(final String[] args) {
    // TODO Auto-generated method stub

    System.out
        .println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out
        .println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));

  }

}
