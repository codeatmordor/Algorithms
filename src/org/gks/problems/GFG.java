package org.gks.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*package whatever //do not write package name here */
import java.util.Scanner;

class GFG {
    public static void main(final String[] args) throws NumberFormatException, IOException {
        // code
        final Scanner scanner = new Scanner(System.in);
        // String myString = scanner.next();

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*
         * String s= inp.readLine(); int[] m= new int[2]; String[] s1 =
         * inp.readLine().split(" "); m[0]=Integer.parseInt(s1[0]);
         * m[1]=Integer.parseInt(s1[1]);
         */
        final int myInt = Integer.parseInt(reader.readLine());
        for (int i = 0; i < myInt; i++) {
            final int numberofE = Integer.parseInt(reader.readLine());
            final int[] m = new int[numberofE - 1];
            final String[] s1 = reader.readLine().split(" ");

            int sum = Integer.parseInt(s1[0]);

            for (int j = 1; j < numberofE - 1; j++) {
                sum = sum ^ Integer.parseInt(s1[j]);
            }
            for (int k = 1; k <= numberofE; k++) {
                sum = sum ^ k;
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}