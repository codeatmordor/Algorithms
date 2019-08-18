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
 * File Name:    LevelOrderTraversal.java
 *
 * Date Created: Aug 18, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Gaurav_Singh3
 *
 */
public class LevelOrderTraversal {

    private class Node {
        String value;
        Node left;
        Node right;

        /**
         * @param value
         */
        public Node(String value) {
            super();
            this.value = value;
        }
    }

    private Node r;

    /**
     * @param r
     */
    public LevelOrderTraversal(String value) {
        super();
        this.r = new Node(value);
        r.left = new Node("b");
        r.right = new Node("c");
        r.left.left = new Node("d");
        r.left.right = new Node("e");
        r.right.left = new Node("f");
        r.right.right = new Node("g");
    }

    public void traverse(Node r) {
        Queue<Node> q = new LinkedList<>();
        q.add(r);
        while (!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.value + " ");
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LevelOrderTraversal l = new LevelOrderTraversal("a");
        l.traverse(l.r);

    }

}
