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
 * File Name:    NoRepeatSubstring.java
 *
 * Date Created: Aug 17, 2019
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
public class NoRepeatSubstring {

    public static int findLength(final String str) {
        int start = 0;
        int end = 0;
        int len = 0;

        // Map to keep indexes of charactes
        final Map<Character, Integer> mf = new HashMap<>();
        for (end = 0; end < str.length(); end++) {
            final Character c = str.charAt(end);
            if (mf.containsKey(c)) {
                start = Math.max(start, mf.get(c) + 1);
            }
            mf.put(c, end);
            len = Math.max(len, end - start + 1);
        }

        return len;

    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));

    }

}
