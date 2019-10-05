
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CheeseCakePlatfrom9 {

    public static int maxCheese(Integer[] cheesArr) {
        int[] cheeseCache = new int[cheesArr.length];
        for (int i = 0; i < cheesArr.length; i++) {
            if (i == 0) {
                cheeseCache[i] = cheesArr[i];
            } else if (i == 1) {
                cheeseCache[i] = Math.max(cheesArr[0], cheesArr[1]);
            } else {
                int p = Math.max(cheesArr[i] + cheeseCache[i - 2], cheeseCache[i - 1]);
                cheeseCache[i] = p;
            }
        }
        return cheeseCache[cheesArr.length - 1];
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String noOfTests = reader.readLine();
            List<List<Integer>> cheeses = new ArrayList<>();
            int n = Integer.parseInt(noOfTests);
            for (int i = 0; i < n; i++) {
                int noOfCheese = Integer.parseInt(reader.readLine());
                String str = reader.readLine();
                String[] strA = str.split(" ");
                List<Integer> l = new ArrayList<>();
                for (int j = 0; j < noOfCheese; j++) {
                    l.add(Integer.parseInt(strA[j]));
                }
                cheeses.add(l);
            }
            for (int i = 0; i < cheeses.size(); i++) {
                List<Integer> in = cheeses.get(i);
                System.out.println(CheeseCakePlatfrom9.maxCheese(in.toArray(new Integer[in.size()])));
            }
        } catch (IOException e) {
            System.out.println("Invalid Input Fromat. " + e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
