
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

public class CheckValidNumber {

    static boolean validNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[] { "10", "0.30", "abc", "10e4", "10e4.5" };
        for (int i = 0; i < strs.length; i++) {
            System.out.println(CheckValidNumber.validNumber(strs[i]));
        }
    }
}
