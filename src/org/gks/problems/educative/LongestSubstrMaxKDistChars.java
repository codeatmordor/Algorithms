package org.gks.problems.educative;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class LongestSubstrMaxKDistChars {

    public static int findLength(String str, int k){

        if(str == null || str.isEmpty() || str.length() < k)
        {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> mf = new HashMap<>();
        int start = 0;
        int end; int length = 0;

        for(end =0; end<str.length();end++){
            final Character c = str.charAt(end);
            mf.put(c, mf.getOrDefault(c, 0) + 1);

            while(mf.size() > k){
                final Character rc = str.charAt(start);
                mf.put(rc, mf.get(rc) - 1);
                if(mf.get(rc) == 0){
                    mf.remove(rc);
                }
                start++;
            }
            System.out.println("Length : "+ length + " Start : " + start + " End : " + end);
            length = Math.max(length, end - start + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: "
                + LongestSubstrMaxKDistChars.findLength("araaci", 2));
        System.out.println("Length of the longest substring: "
                + LongestSubstrMaxKDistChars.findLength("araaci", 1));
        System.out.println("Length of the longest substring: "
                + LongestSubstrMaxKDistChars.findLength("cbbebi", 3));

        System.out.println("Length of the longest substring: "
                + LongestSubstrMaxKDistChars.findLength("aaadj", 2));
    }
}
