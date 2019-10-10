package org.gks.problems.slidingwindow;

public class LongestSubarrayWith1sAfterReplacement {

  public static int findLength(final int[] arr, final int k) {
    int start = 0;
    int end = 0;
    int maxOnesCount = 0;
    int len = 0;

    for (end = 0; end < arr.length; end++) {
      if (arr[end] == 1)
        maxOnesCount++;

      // current window size is from windowStart to windowEnd, overall we
      // have a maximum of 1s
      // repeating a maximum of 'maxOnesCount' times, this means that we
      // can have a window with
      // 'maxOnesCount' 1s and the remaining are 0s which should replace
      // with 1s.
      // now, if the remaining 0s are more than 'k', it is the time to
      // shrink the window as we
      // are not allowed to replace more than 'k' Os
      if (end - start + 1 - maxOnesCount > k) {
        if (arr[start] == 1) {
          maxOnesCount--;
        }
        start++;
      }
      len = Math.max(len, end - start + 1);

    }
    return len;

  }

  public static void main(final String[] args) {
    System.out.println(LongestSubarrayWith1sAfterReplacement
        .findLength(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
    System.out.println(LongestSubarrayWith1sAfterReplacement
        .findLength(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));

  }

}
