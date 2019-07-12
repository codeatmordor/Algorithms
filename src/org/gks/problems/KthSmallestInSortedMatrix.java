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
 * File Name:    KthSmalletInSortedMatrix.java
 *
 * Date Created: Jul 6, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems;

import java.util.PriorityQueue;

class Node {
    int row;
    int col;

    Node(final int row, final int col) {
        this.row = row;
        this.col = col;
    }
}

public class KthSmallestInSortedMatrix {

    public static int findKthSmallest(final int[][] matrix, final int k) {
        final PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));

        // take the smallest (top) element form the min heap, if the running
        // count is equal to k return the number
        // if the row of the top element has more elements, add the next element
        // to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            final Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k)
                break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }

    public static void main(final String[] args) {
        final int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        final int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}