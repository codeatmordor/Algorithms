package org.gks.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurav_Singh3
 *
 */
public class LongestSubstrWithSameLettersAfterReplacement {

  public static int findLength(final String str, final int k) {
    int start = 0, end = 0;
    int maxRepeatCharCount = 0;
    int len = 0;
    final Map<Character, Integer> mf = new HashMap<>();

    for (end = 0; end < str.length(); end++) {
      final Character c = str.charAt(end);
      mf.put(c, mf.getOrDefault(c, 0) + 1);
      maxRepeatCharCount = Math.max(maxRepeatCharCount, mf.get(c));

      // current window size is from windowStart to windowEnd, overall we
      // have a letter which is
      // repeating 'maxRepeatLetterCount' times, this means we can have a
      // window which has one letter
      // repeating 'maxRepeatLetterCount' times and the remaining letters
      // we should replace.
      // if the remaining letters are more than 'k', it is the time to
      // shrink the window as we
      // are not allowed to replace more than 'k' letters
      if (end - start + 1 - maxRepeatCharCount > k) {
        final Character cl = str.charAt(start);
        mf.put(cl, mf.get(cl) - 1);
        start++;
      }
      len = Math.max(len, end - start + 1);
    }
    return len;

  }

  public static void main(final String[] args) {
    System.out.println(LongestSubstrWithSameLettersAfterReplacement.findLength("aabccbb", 2));
    System.out.println(LongestSubstrWithSameLettersAfterReplacement.findLength("abbcb", 1));
    System.out.println(LongestSubstrWithSameLettersAfterReplacement.findLength("abccde", 1));

  }

}
