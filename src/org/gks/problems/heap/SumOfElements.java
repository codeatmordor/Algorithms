// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.heap;

import java.util.PriorityQueue;


// Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that
// array.


/*
 * We can find the sum of all numbers coming between the K1’th and K2’th smallest numbers in the
 * following steps:
 * 
 * First, insert all numbers in a min-heap. Remove the first K1 smallest numbers from the min-heap.
 * Now take the next K2-K1-1 numbers out of the heap and add them. This sum will be our required
 * output.
 */
public class SumOfElements {

  public static int findSumOfElements(int[] nums, int k1, int k2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
    // insert all numbers to the min heap
    for (int i = 0; i < nums.length; i++)
      minHeap.add(nums[i]);

    // remove k1 small numbers from the min heap
    for (int i = 0; i < k1; i++)
      minHeap.poll();

    int elementSum = 0;
    // sum next k2-k1-1 numbers
    for (int i = 0; i < k2 - k1 - 1; i++)
      elementSum += minHeap.poll();

    return elementSum;
  }

  public static void main(String[] args) {
    int result = SumOfElements.findSumOfElements(new int[] {1, 3, 12, 5, 15, 11}, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] {3, 5, 8, 7}, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}
