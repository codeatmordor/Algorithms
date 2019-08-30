
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

interface Square {
    int calculate(int x);
}

public class FInterface {

    public static void main(String[] args) {

        Square s = (int x) -> x * x;

        int ans = s.calculate(8);

        System.out.println(ans);

        new Thread(() -> {
            System.out.println("Gaurav");
        }).start();

        /*
         * Predicate
         */

        List<String> str = Arrays.asList(new String[] { "Gaurav", "Gola", "Hat" });

        Predicate<String> m = (p) -> p.startsWith("G");

        for (String string : str) {
            System.out.println(m.test(string));
        }
    }

}
