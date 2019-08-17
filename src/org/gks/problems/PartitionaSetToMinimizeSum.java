/** SYMANTEC: Copyright 2019 Symantec Corporation. All rights reserved.
 * THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION AND TRADE SECRETS OF
 * SYMANTEC CORPORATION.USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED
 * WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF SYMANTEC CORPORATION.
 * The Licensed Software and Documentation are deemed to be commercial
 * computer software as defined in FAR 12.212 and subject to restricted
 * rights as defined in FAR Section 52.227-19 "Commercial Computer Software
 * - Restricted Rights" and DFARS 227.7202, "Rights in Commercial Computer
 * Software or Commercial Computer Software Documentation", as applicable,
 * and any successor regulations.  Any use, modification, reproduction
 * release, performance, display or disclosure of the Licensed Software
 * and Documentation by the U.S. Government shall be solely in accordance
 * with the terms of this Agreement.
 */
/********************************************************************
 * File Name:    PartitionaSetToMinimizeSum.java
 *
 * Date Created: Jul 13, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

/**
 * @author Gaurav_Singh3
 *
 */

/*
 * Input: arr[] = {1, 6, 11, 5} Output: 1 Explanation: Subset1 = {1, 5, 6}, sum
 * of Subset1 = 12 Subset2 = {11}, sum of Subset2 = 11
 */
public class PartitionaSetToMinimizeSum {

    public static void main(final String[] args) {
        final int arr[] = { 3, 1, 4 };
        final int n = arr.length;
        System.out.print("The minimum difference" + " between two sets is " + findMin(arr, n));
    }

    public static int findMin(final int[] arr, final int n) {
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            sumTotal += arr[i];
        }
        return findMinRec(arr, n, 0, sumTotal);
    }

    public static int findMinRec(final int[] arr, final int i, final int sumCalculated, final int sumTotal) {

        System.out.println("called with - " + i + " " + sumCalculated + " " + sumTotal);
        // If we have reached last element.
        // Sum of one subset is sumCalculated,
        // sum of other subset is (sumTotal-
        // sumCalculated). Return absolute
        // difference of two sums.
        if (i == 0)
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);

        // For every item arr[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
        return Math.min(findMinRec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal), findMinRec(arr, i - 1, sumCalculated, sumTotal));
    }
}
