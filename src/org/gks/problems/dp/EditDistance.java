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
 * File Name:    EditDistance.java
 *
 * Date Created: Jul 13, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.dp;

/**
 * @author Gaurav_Singh3
 *
 */
public class EditDistance {

    public static void main(final String args[]) {
        final String str1 = "abc";
        final String str2 = "xyz";

        System.out.println(editDistRec(str1, str2, str1.length(), str2.length()));
    }

    public static int min(final int x, final int y, final int z) {
        if (x <= y && x <= z)
            return x;
        else if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    public static int editDistRec(final String str1, final String str2, final int m, final int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDistRec(str1, str2, m - 1, n - 1);

        return 1 + min(editDistRec(str1, str2, m - 1, n), editDistRec(str1, str2, m, n - 1), editDistRec(str1, str2, m - 1, n - 1));
    }
}
