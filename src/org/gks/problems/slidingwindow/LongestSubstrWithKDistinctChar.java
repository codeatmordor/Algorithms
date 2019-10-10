package org.gks.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurav_Singh3
 *
 */
public class LongestSubstrWithKDistinctChar {

  public static int findLength(final String str, final int k) {
    if (str == null || str.length() == 0 || str.length() < k) {
      throw new IllegalArgumentException();
    }

    int start = 0;
    int end = 0;
    int length = 0;
    final Map<Character, Integer> mf = new HashMap<>();

    for (end = 0; end < str.length(); end++) {
      final Character c = str.charAt(end);
      mf.put(c, mf.getOrDefault(c, 0) + 1);
      if (mf.size() > k) {
        final Character rc = str.charAt(start);
        mf.put(rc, mf.get(rc) - 1);
        if (mf.get(rc) == 0) {
          mf.remove(rc);
        }
        start++;
      }
      length = Math.max(length, end - start + 1);
    }
    return length;

  }

  public static void main(final String[] args) {
    System.out.println("Length of the longest substring: "
        + LongestSubstrWithKDistinctChar.findLength("araaci", 2));
    System.out.println("Length of the longest substring: "
        + LongestSubstrWithKDistinctChar.findLength("araaci", 1));
    System.out.println("Length of the longest substring: "
        + LongestSubstrWithKDistinctChar.findLength("cbbebi", 3));
  }

}
