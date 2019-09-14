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
 * File Name:    AverageOfSubarrayOfSizeK.java
 *
 * Date Created: Jul 6, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.misc;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(final int K, final int[] arr) {
        final double[] result = new double[arr.length - K + 1];
        for (int i = 0; i <= arr.length - K; i++) {
            // find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i + K; j++)
                sum += arr[j];
            result[i] = sum / K; // calculate average
        }

        return result;
    }

    public static void main(final String[] args) {
        final double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}