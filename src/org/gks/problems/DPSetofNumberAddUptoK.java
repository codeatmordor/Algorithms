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
 * File Name:    DPSetofNumberAddUptoK.java
 *
 * Date Created: Jul 12, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------

/**
 * @author Gaurav_Singh3
 *
 */

package org.gks.problems;

import java.util.HashMap;

public class DPSetofNumberAddUptoK {

    public static void main(final String args[]) {
        // input will always be positive numbers
        final int[] input = { 4, 3, 4, 1, 2, 3, 1, 7, 5 };
        System.out.println("Number of Sets " + dpCountSets(input, 8));

    }

    public static int getSetOfNUmbers(final int[] inputArr, final int total) {
        // final List<List<Integer>> result = new ArrayList<>();
        return rec(inputArr, total, inputArr.length - 1);
    }

    private static int rec(final int[] arr, final int total, final int i) {
        if (total == 0)
            return 1;
        else if (total < 0)
            return 0;
        else if (i < 0)
            return 0;
        else if (total < arr[i])
            return rec(arr, total, i - 1);
        else
            return rec(arr, total - arr[i], i - 1) + rec(arr, total, i - 1);

    }

    public static int dpCountSets(final int[] arr, final int total) {
        final HashMap<String, Integer> mem = new HashMap<>();
        return dprec(arr, total, arr.length - 1, mem);
    }

    private static int dprec(final int[] arr, final Integer total, final Integer i, final HashMap<String, Integer> mem) {

        final String key = total.toString() + ":" + i.toString();

        if (mem.containsKey(key)) {
            System.out.println("key- " + key);
            return mem.get(key);
        }

        int result;
        System.out.println("Called");
        if (total == 0)
            return 1;
        else if (total < 0)
            return 0;
        else if (i < 0)
            return 0;
        else if (total < arr[i])
            result = dprec(arr, total, i - 1, mem);
        else
            result = dprec(arr, total - arr[i], i - 1, mem) + dprec(arr, total, i - 1, mem);

        mem.put(key, result);
        return result;
    }

}
