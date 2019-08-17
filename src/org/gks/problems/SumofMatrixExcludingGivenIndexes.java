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
 * File Name:    SumofMatrixExcludingGivenIndexes.java
 *
 * Date Created: Jul 14, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gaurav_Singh3
 *
 */
// https://www.geeksforgeeks.org/find-sum-of-all-elements-in-a-matrix-except-the-elements-in-given-row-andor-column-2/
public class SumofMatrixExcludingGivenIndexes {

    public static void main(final String[] args) {
        /*
         * final List<List<Integer>> input = new ArrayList<>(); final
         * List<Integer> a = Arrays.asList(new Integer[] { 1, 1, 2 }); final
         * List<Integer> b = Arrays.asList(new Integer[] { 3, 4, 6 }); final
         * List<Integer> c = Arrays.asList(new Integer[] { 5, 3, 2 });
         * input.add(a); input.add(b); input.add(c);
         */

        final int input[][] = { { 1, 1, 2 }, { 3, 4, 6 }, { 5, 3, 2 } };

    }

    public class index {
        int r;
        int c;

        public index(final int i, final int j) {
            r = i;
            c = j;
        }
    }

    public static List<Integer> getsum(final List<List<Integer>> input, final List<index> indexes) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indexes.size(); i++) {
            int sum = 0;
            final int r = indexes.get(i).r;
            final int c = indexes.get(i).c;
            for (int j = 0; j < input.size(); j++) {
                for (int k = 0; k < input.size(); k++) {
                    if (k != c && j != r) {
                        sum += input.get(j).get(k);
                    }
                }
            }
            res.add(sum);
        }
        return res;
    }

}
