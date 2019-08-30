
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

public class ReverseString {

    public static void reverse(String str) {

        char[] cArr = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;

        for (; l <= r; l++, r--) {
            char temp = cArr[l];
            cArr[l] = cArr[r];
            cArr[r] = temp;
        }

        System.out.println(new String(cArr));
    }

    public static void main(String[] args) {
        ReverseString.reverse("reverse me");
    }

}
