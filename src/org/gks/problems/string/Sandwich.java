
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.string;

public class Sandwich {
    public static String findSandwich(String str) {
        if (str.length() < 5)
            return "";

        int beginindex = str.indexOf("bread");
        int lastIndex = str.lastIndexOf("bread");

        if (lastIndex != -1 && (beginindex != lastIndex)) {
            return str.substring(beginindex + 5, lastIndex);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(Sandwich.findSandwich("breadjambread"));
        System.out.println(Sandwich.findSandwich("xxbreadjambreadyy"));
        System.out.println(Sandwich.findSandwich("breadgauravbread"));
        System.out.println(Sandwich.findSandwich("breadgaurav"));
    }

}
