package org.gks.problems.educative;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 */
public class SmallestSubArrayWithGivenSum {

    public static int findMinSubArray(int s, int[] input){
        int windowSum =0; int minLength=Integer.MAX_VALUE;
        int windowStart =0;

        for(int windowEnd=0; windowEnd<input.length;windowEnd++){
            windowSum+=input[windowEnd];

            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while(windowSum>=s){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum = windowSum - input[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }

    public static void main(String[] args){
        int result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, -3, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, -1 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
