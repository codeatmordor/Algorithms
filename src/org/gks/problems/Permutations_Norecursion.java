package org.gks.problems;
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
 * File Name:    Practice.java
 *
 * Date Created: Jul 6, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Gaurav_Singh3
 *
 */
public class Permutations_Norecursion {

    public static List<List<Integer>> findSubsets(final int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final Queue<List<Integer>> perms = new LinkedList<>();
        perms.add(new ArrayList<>());

        for (final Integer currNumber : nums) {
            final int n = perms.size();
            for (int i = 0; i < n; i++) {
                final List<Integer> oldPermutation = perms.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    final List<Integer> s = new ArrayList<>(oldPermutation);
                    s.add(j, currNumber);
                    if (s.size() == nums.length)
                        result.add(s);
                    else
                        perms.add(s);
                }
            }
        }
        return result;
    }

    public static void main(final String[] args) {
        List<List<Integer>> result = Permutations_Norecursion.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Permutations_Norecursion.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
