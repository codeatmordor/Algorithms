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
 * File Name:    MaxSubarrayWithElementGreaterThanK.java
 *
 * Date Created: Aug 17, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.misc;

/**
 * @author Gaurav_Singh3
 *
 */
public class MaxSubarrayWithElementGreaterThanK {

    public static int longestSubarray(final int[] a, final int n, final int k) {

        int maxl = 0;
        int currl = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > k) {
                currl += 1;
            } else {
                maxl = Math.max(currl, maxl);
                currl = 0;
            }
        }
        if (currl > 0) {
            maxl = Math.max(currl, maxl);
        }
        return maxl;
    }

    public static void main(final String[] args) {
        final int[] a = { 8, 25, 10, 19, 19, 18, 20, 14, 18 };
        final int n = a.length;
        final int k = 13;
        System.out.println(longestSubarray(a, n, k));

    }

}
