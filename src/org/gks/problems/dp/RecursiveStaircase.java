
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.dp;

// https://www.youtube.com/watch?v=5o-kdjv7FD0&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=2
public class RecursiveStaircase {

    static int noOfWaysToClimbStairs(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysToClimbStairs(4));
    }

}
