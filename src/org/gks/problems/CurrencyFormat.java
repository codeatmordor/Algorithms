
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

import java.util.Scanner;

public class CurrencyFormat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "This is an example string, right?  Yes!";
        s = s.trim();
        String delims = "[ .,?!]+";
        String[] tokens = s.split(delims);
        System.out.println(tokens.length);
        for (String string : tokens) {
            System.out.println(string);
        }
    }

}
