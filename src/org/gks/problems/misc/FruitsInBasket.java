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
 * File Name:    FruitsInBasket.java
 *
 * Date Created: Aug 16, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurav_Singh3
 *
 */

/*
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits in
 * each basket. The only restriction is that each basket can have only one type
 * of fruit.
 * 
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e., you will stop
 * when you have to pick from a third fruit type.
 * 
 * Write a function to return the maximum number of fruits in both the baskets.
 */
public class FruitsInBasket {

    public static int findLength(final char[] arr) {
        int start = 0;
        int maxLength = 0;
        final Map<Character, Integer> fmap = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            fmap.put(arr[end], fmap.getOrDefault(arr[end], 0) + 1);
            while (fmap.size() > 2) {
                fmap.put(arr[start], fmap.get(arr[start]) - 1);
                if (fmap.get(arr[start]) == 0) {
                    fmap.remove(arr[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(final String[] args) {
        System.out.println("Maximum number of fruits: " + FruitsInBasket.findLength(new char[] { 'A', 'B', 'C', 'A', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " + FruitsInBasket.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }

}
