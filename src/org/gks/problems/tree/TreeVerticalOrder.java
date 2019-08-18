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
 * File Name:    TreeVerticalOrder.java
 *
 * Date Created: Jul 14, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

/**
 * @author Gaurav_Singh3
 *
 */
public class TreeVerticalOrder {

    static class Node {
        int key;
        Node left;
        Node right;

        // Constructor
        Node(final int data) {
            key = data;
            left = null;
            right = null;
        }
    }

    // Utility function to store vertical order in map 'm'
    // 'hd' is horizontal distance of current node from root.
    // 'hd' is initially passed as 0
    public static void getVerticalOrder(final Node root, final int hd, final TreeMap<Integer, Vector<Integer>> m) {
        // Base case
        if (root == null)
            return;

        // get the vector list at 'hd'
        Vector<Integer> get = m.get(hd);

        get = get == null ? new Vector<>() : m.get(hd);
        get.add(root.key);
        m.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd - 1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd + 1, m);
    }

    // The main function to print vertical oder of a binary tree
    // with given root
    static void printVerticalOrder(final Node root) {
        // Create a map and store vertical oder in map using
        // function getVerticalOrder()
        final TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        final int hd = 0;
        getVerticalOrder(root, hd, m);

        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        for (final Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(final String[] args) {

        // TO DO Auto-generated method stub
        final Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }

}
