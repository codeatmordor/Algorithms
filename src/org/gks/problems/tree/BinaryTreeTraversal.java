
/********************************************************************
 * File Name:    BinaryTreeLevelOrder.java
 *
 * Date Created: Aug 22, 2019
 *
 * ------------------------------------------------------------------
 *
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

public class BinaryTreeTraversal {

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

    public static boolean hasPath(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (root.val == sum && root.left == null && root.right == null)
            return true;

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);

    }

    public static List<List<Integer>> findAllPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        findPathRec(root, sum, allPaths, currPath);
        return allPaths;
    }

    private static void findPathRec(TreeNode curr, int sum, List<List<Integer>> allPaths, List<Integer> path) {
        if (curr == null)
            return;

        path.add(curr.val);

        if (curr.val == sum && curr.left == null && curr.right == null) {
            allPaths.add(new ArrayList<>(path));
        } else {

            findPathRec(curr.left, sum - curr.val, allPaths, path);

            findPathRec(curr.right, sum - curr.val, allPaths, path);

        }

        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> findAllRootToLeafPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        findPathRec2(root, allPaths, currPath);
        return allPaths;
    }

    private static void findPathRec2(TreeNode curr, List<List<Integer>> allPaths, List<Integer> path) {
        if (curr == null)
            return;

        path.add(curr.val);

        if (curr.left == null && curr.right == null) {
            allPaths.add(new ArrayList<>(path));
        } else {

            findPathRec2(curr.left, allPaths, path);

            findPathRec2(curr.right, allPaths, path);

        }

        path.remove(path.size() - 1);
    }

    public static void printTreeBoundary(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        ArrayList<TreeNode> rview = new ArrayList<>();
        ArrayList<TreeNode> lview = new ArrayList<>();

        while (!q.isEmpty()) {
            int lsize = q.size();

            for (int i = 0; i < lsize; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    continue;
                if (i == 0)
                    lview.add(node);
                if (i + 1 == lsize)
                    rview.add(node);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

            }
        }

        res.addAll(lview);
        res.addAll(findLeavesDFS(root));
        res.addAll(rview);

        res.stream().forEach(s -> System.out.print(s.val + " "));
    }

    private static List<TreeNode> findLeavesDFS(TreeNode root) {
        List<TreeNode> leaves = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.left == null && currentNode.right == null)
                leaves.add(currentNode);

            // insert the children of current node in the stack
            // add the right child first, this way left child will be at the top
            // and processed first
            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
        }
        return leaves;
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

    /*
     * =======================================================================
     */
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

    public static List<TreeNode> rightViewOfTree(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // if it is the last node of this level, add it to the result
                if (i == levelSize - 1)
                    result.add(currentNode);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }

        return result;
    }

    BinaryTreeTraversal() {

    }

    static class Maximum {
        int max = Integer.MIN_VALUE;
    }

    public static void getTargetLeafNode(TreeNode node, Maximum max, int currsum) {
        if (node == null)
            return;

        currsum += node.val;

        if (node.left == null && node.right == null) {
            if (currsum > max.max) {
                max.max = currsum;
                targetLeaf = node;
            }
        }

        getTargetLeafNode(node.left, max, currsum);
        getTargetLeafNode(node.right, max, currsum);
    }

    public static boolean printPath(TreeNode node, TreeNode targNode) {
        if (node == null)
            return false;

        if (node == targNode || printPath(node.left, targNode) || printPath(node.right, targNode)) {
            System.out.println(node.val + " ");
            return true;
        }
        return false;
    }

    public static int maxSumPath(TreeNode n) {
        if (n == null)
            return 0;

        getTargetLeafNode(n, max, 0);

        printPath(n, targetLeaf);
        return max.max;
    }

    TreeNode r;
    static TreeNode targetLeaf;
    static Maximum max = new Maximum();

    public static void main(String[] args) {
        // max = new Maximum();
        BinaryTreeTraversal b = new BinaryTreeTraversal();
        b.r = new TreeNode(5);
        b.r.left = new TreeNode(6);
        b.r.right = new TreeNode(7);
        b.r.left.left = new TreeNode(8);
        b.r.left.right = new TreeNode(9);
        b.r.right.left = new TreeNode(10);
        b.r.right.right = new TreeNode(11);

        newline("levelOrder");
        BinaryTreeTraversal.levelOrder(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        newline("reverselevelOrder");

        BinaryTreeTraversal.reverselevelOrder(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        newline("zigzag");

        BinaryTreeTraversal.zigzag(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        newline("levelAverage");

        BinaryTreeTraversal.levelAverage(b.r).stream().forEach(s -> System.out.println(s + " "));

        newline("levelordersuccessor");

        System.out.println(BinaryTreeTraversal.levelordersuccessor(b.r, 11));

        newline("connectlevelordersiblings");

        BinaryTreeTraversal.connectlevelordersiblings(b.r);

        newline("convertalllevelorder");

        BinaryTreeTraversal.convertalllevelorder(b.r);

        newline("rightViewOfTree");

        BinaryTreeTraversal.rightViewOfTree(b.r).stream().forEach(s -> System.out.print(s.val + " "));

        newline("printTreeBoundary");

        BinaryTreeTraversal.printTreeBoundary(b.r);

        newline("hasPath");
        System.out.println(BinaryTreeTraversal.hasPath(b.r, 19));

        newline("findAllRootToLeafPaths");

        BinaryTreeTraversal.findAllRootToLeafPaths(b.r).stream().forEach(l -> {
            l.stream().forEach(s -> System.out.print(s + " "));
            System.out.println();
        });

        newline("maxSumPath");

        System.out.println(BinaryTreeTraversal.maxSumPath(b.r));

    }

    /**
     *
     */
    private static void newline(String methodName) {

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());
        System.out.println("/*************************** " + methodName + " *****************************************************/");
        System.out.println();
    }

}
