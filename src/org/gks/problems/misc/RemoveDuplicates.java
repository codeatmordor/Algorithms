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
 * File Name:    RemoveDuplicates.java
 *
 * Date Created: Aug 16, 2019
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
public class RemoveDuplicates {

    public static void main(final String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }

    public static int remove(final int[] arr) {

        int j = 1;
        int nextnondup = 1;

        for (j = 1; j < arr.length; j++) {
            if (arr[nextnondup - 1] != arr[j]) {
                arr[nextnondup] = arr[j];
                nextnondup++;
            }
        }
        return nextnondup;
    }

}
