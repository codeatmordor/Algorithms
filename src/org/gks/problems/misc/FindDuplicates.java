package org.gks.problems.misc;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    // Return a list of duplicates in the array. To avoid using extra space,
    // we flag which elements we've seen before by negating the value at
    // indexed at that value in the array.
    public static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                res.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 2, 3, 1, 2 };
        findDuplicates(input).stream().forEach(s -> System.out.print(s + " "));
    }

}
