
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

public class AllSubStrings {

    public static void subs(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        AllSubStrings.subs("NarendraDamodarDasModiIsGreat");
    }
}
