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
 * File Name:    StringDeletion.java
 *
 * Date Created: Aug 18, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Gaurav_Singh3
 *
 */
public class StringDeletion {

    /*
     * Given a string and a dictionary HashSet, write a function to determine
     * the minimum number of characters to delete to make a word. dictionary:
     * [“a”, “aa”, “aaa”] , query: “abc” ,output: 2
     *
     */

    public static void main(String[] args) {
        HashSet<String> s = new HashSet<>();
        s.add("a");
        s.add("aa");
        s.add("aaa");

        String q = "abcde";
        System.out.println(getMinOp(q, s));
    }

    // abc
    // / \ \
    // ab bc ac
    // /\ /\ /\
    // a b b c a c
    public static int getMinOp(String str, HashSet<String> dict) {
        Queue<String> q = new LinkedList<>();
        Set<String> eSet = new HashSet<>();
        q.add(str);
        eSet.add(str);

        while (!q.isEmpty()) {
            String s = q.remove();
            eSet.remove(s);
            if (dict.contains(s)) {
                return str.length() - s.length();
            }
            for (int i = 0; i < s.length(); i++) {
                String substr = s.substring(0, i) + s.substring(i + 1, s.length());
                if (!eSet.contains(substr) && substr.length() > 0) {
                    q.add(substr);
                    eSet.add(substr);
                }
            }
        }
        return -1;
    }

}
