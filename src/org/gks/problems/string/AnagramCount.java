
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

public class AnagramCount {
    final static int MAX_CHAR = 256;

    static boolean isCountZero(int[] count) {
        for (int i = 0; i < MAX_CHAR; i++) {
            {
                if (count[i] != 0)
                    return false;
            }
        }
        return true;
    }

    static int countAnagrams(String text, String word) {
        int[] count = new int[MAX_CHAR];
        int res = 0;
        int N = text.length();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            count[word.charAt(i)]++;
        }
        for (int i = 0; i < n; i++) {
            count[text.charAt(i)]--;
        }

        if (isCountZero(count)) {
            res++;
        }

        for (int i = n; i < N; i++) {
            count[text.charAt(i)]--;
            count[text.charAt(i - n)]++;
            if (isCountZero(count))
                res++;
        }
        return res;

    }

    public static void main(String[] args) {
        String text = "Gaurav";
        String word = "var";
        System.out.print(countAnagrams(text, word));
    }

}
