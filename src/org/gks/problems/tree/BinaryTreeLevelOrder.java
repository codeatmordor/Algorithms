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
 * File Name:    BinaryTreeLevelOrder.java
 *
 * Date Created: Aug 22, 2019
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2019 Symantec Ltd. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Gaurav_Singh3
 *
 */
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    /**
     * @param val
     */
    public TreeNode(int val) {
        super();
        this.val = val;
        this.next = null;
    }
}

public class BinaryTreeLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.add(r);

        int level = 1;
        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(l);
        }

        return res;

    }

    public static List<List<Integer>> zigzag(TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q.add(r);

        int level = 1;
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (leftToRight)
                    l.add(node.val);
                else
                    l.add(0, node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(l);
            leftToRight = !leftToRight;
        }

        return res;

    }

    public static void printLevelOrder(TreeNode r) {
        TreeNode nextLevelRoot = r;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void connectlevelordersiblings(TreeNode r) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            int level = q.size();

            TreeNode prev = null;

            for (int i = 0; i < level; i++) {
                TreeNode curr = q.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

        }
        printLevelOrder(r);

    }

    public static int levelordersuccessor(TreeNode r, int m) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
            if (n.val == m) {
                TreeNode next = q.poll();
                if (next != null)
                    return next.val;
            }

        }
        return -1;
    }

    public static int minimumTreeDepth(TreeNode r) {
        if (r == null)
            return 0;

        int minimumDepth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            minimumDepth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    return minimumDepth;

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

        }
        return minimumDepth;
    }

    public static List<List<Integer>> reverselevelOrder(TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        q.add(r);

        int level = 1;
        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(0, l);
        }

        return res;

    }

    public static List<Float> levelAverage(TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Float> res = new LinkedList<>();
        q.add(r);

        int level = 1;
        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int levelSize = q.size();
            float levelVal = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                levelVal += node.val;
                l.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            res.add(levelVal / levelSize);
        }

        return res;
    }

    public static void convertalllevelorder(TreeNode r) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(r);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
            // if (q.peek() != null) {
            node.next = q.peek();
            // }

        }

        printTree(r);
    }

    public static void printTree(TreeNode r) {
        TreeNode current = r;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    BinaryTreeLevelOrder() {

    }

    TreeNode r;

    public static void main(String[] args) {

        BinaryTreeLevelOrder b = new BinaryTreeLevelOrder();
        b.r = new TreeNode(5);
        b.r.left = new TreeNode(6);
        b.r.right = new TreeNode(7);
        b.r.left.left = new TreeNode(8);
        b.r.left.right = new TreeNode(9);
        b.r.right.left = new TreeNode(10);
        b.r.right.right = new TreeNode(11);
        b.levelOrder(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        b.reverselevelOrder(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        b.zigzag(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        b.levelAverage(b.r).stream().forEach(s -> System.out.println(s + " "));

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        System.out.println(b.levelordersuccessor(b.r, 11));

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        b.connectlevelordersiblings(b.r);

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        b.convertalllevelorder(b.r);

    }

}
