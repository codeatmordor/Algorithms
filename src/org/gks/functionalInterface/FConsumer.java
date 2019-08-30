
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FConsumer {

    public static void main(String[] args) {
        Consumer<Integer> c = i -> System.out.println(i + " ");

        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        print(l, c);
    }

    private static void print(List<Integer> l, Consumer<Integer> i) {
        for (Integer integer : l) {
            i.accept(integer);
        }
    }

}
