package org.gks.problems.educative;


/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 */

public class MaximumSumSubarraySizeK {

    public static int findMaxSumSubArray(int[] input, int k){
        int maxSum = 0;
            for(int i=0; i<input.length - k ;i++){
                int sum =0;
                for(int j=i;j<i+k;j++){
                    sum += input[j];
                }
                if(sum>=maxSum){
                    maxSum = sum;
                }
            }
            return maxSum;
    }

    public static int findMaxSumSubArraySlidingWindow(int[] input, int k){
        int msum =0; int wsum=0;
        int start =0;

        for(int i=0;i<=input.length - 1;i++){
            wsum+=input[i];

            if(i >= k-1){
                msum = Math.max(wsum,msum);
                wsum = wsum - input[start];
                start++;
            }
        }
        return msum;
    }
    public static void main(String[] args){
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarraySizeK.findMaxSumSubArray(new int[] { 2, 1, 5, 1, 3, 2 }, 3));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarraySizeK.findMaxSumSubArray(new int[] { 2, 3, 4, 1, 5 }, 2));


        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarraySizeK.findMaxSumSubArraySlidingWindow(new int[] { 2, 1, 5, 1, 3, 2 }, 3));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaximumSumSubarraySizeK.findMaxSumSubArraySlidingWindow(new int[] { 2, 3, 4, 1, 5 }, 2));
    }

}
