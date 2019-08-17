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
 * File Name:    LongestSubstrWithKDistinctChar.java
 *
 * Date Created: Aug 17, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurav_Singh3
 *
 */
public class LongestSubstrWithKDistinctChar {

    public static int findLength(final String str, final int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int end = 0;
        int length = 0;
        final Map<Character, Integer> mf = new HashMap<>();

        for (end = 0; end < str.length(); end++) {
            final Character c = str.charAt(end);
            mf.put(c, mf.getOrDefault(c, 0) + 1);
            if (mf.size() > k) {
                final Character rc = str.charAt(start);
                mf.put(rc, mf.get(rc) - 1);
                if (mf.get(rc) == 0) {
                    mf.remove(rc);
                }
                start++;
            }
            length = Math.max(length, end - start + 1);
        }
        return length;

    }

    public static void main(final String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstrWithKDistinctChar.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstrWithKDistinctChar.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstrWithKDistinctChar.findLength("cbbebi", 3));
    }

}
