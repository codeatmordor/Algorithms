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
 * File Name:    LongestSubarrayWith1sAfterReplacement.java
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
public class LongestSubarrayWith1sAfterReplacement {

    public static int findLength(final int[] arr, final int k) {
        int start = 0;
        int end = 0;
        int maxOnesCount = 0;
        int len = 0;

        for (end = 0; end < arr.length; end++) {
            if (arr[end] == 1)
                maxOnesCount++;

            // current window size is from windowStart to windowEnd, overall we
            // have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we
            // can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace
            // with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to
            // shrink the window as we
            // are not allowed to replace more than 'k' Os
            if (end - start + 1 - maxOnesCount > k) {
                if (arr[start] == 1) {
                    maxOnesCount--;
                }
                start++;
            }
            len = Math.max(len, end - start + 1);

        }
        return len;

    }

    public static void main(final String[] args) {
        System.out.println(LongestSubarrayWith1sAfterReplacement.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(LongestSubarrayWith1sAfterReplacement.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

    }

}
