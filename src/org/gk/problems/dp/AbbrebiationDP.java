
// PACKAGE/IMPORTS --------------------------------------------------
package org.gk.problems.dp;

public class AbbrebiationDP {

    static String abbreviation(String a, String b) {
        boolean[][] isValid = new boolean[a.length() + 1][b.length() + 1];
        // initializing the first raw to all false; i.e. if b is
        // not empty, isValid will always be false
        isValid[0][0] = true;
        // array initialization - if a is non-empty but b is empty,
        // then isValid == true iff remaining(a) != contain uppercase
        boolean containsUppercase = false;
        for (int k = 1; k <= a.length(); k++) {
            int i = k - 1;
            // if the pointer at string a is uppercase
            if (a.charAt(i) <= 90 && a.charAt(i) >= 65 || containsUppercase) {
                containsUppercase = true;
                isValid[k][0] = false;
            } else
                isValid[k][0] = true;
        }
        // tabulation from start of string
        for (int k = 1; k <= a.length(); k++) {
            for (int l = 1; l <= b.length(); l++) {
                int i = k - 1;
                int j = l - 1;
                // when the characters are equal, set = previous character bool.
                if (a.charAt(i) == b.charAt(j)) {
                    isValid[k][l] = isValid[k - 1][l - 1];
                    continue;
                }
                // elif uppercase a == b, set = prev character bool. or just eat
                // a.
                else if (a.charAt(i) - 32 == b.charAt(j)) {
                    isValid[k][l] = isValid[k - 1][l - 1] || isValid[k - 1][l];
                    continue;
                }
                // elif a is uppercase and no more b, or uppercase a is not b,
                // then false
                else if (a.charAt(i) <= 90 && a.charAt(i) >= 65) {
                    isValid[k][l] = false;
                    continue;
                }
                // else just eat a
                else {
                    isValid[k][l] = isValid[k - 1][l];
                    continue;
                }
            }
        }
        return isValid[a.length()][b.length()] ? "YES" : "NO";
    }
}
