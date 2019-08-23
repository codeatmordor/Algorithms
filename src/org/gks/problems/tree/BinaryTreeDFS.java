
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /**
     * @param val
     */
    public TreeNode(int val) {
        super();
        this.val = val;
    }
}

public class BinaryTreeDFS {

    public static void findRootToLeafPathNumber(TreeNode curr, int pathSum, List<Integer> res) {
        if (curr == null)
            return;

        pathSum = 10 * pathSum + curr.val;
        if (curr.left == null && curr.right == null) {
            res.add(pathSum);
            pathSum = 0;
        }

        findRootToLeafPathNumber(curr.left, pathSum, res);
        findRootToLeafPathNumber(curr.right, pathSum, res);

    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        r.left = new TreeNode(6);
        r.right = new TreeNode(7);
        r.left.left = new TreeNode(8);
        r.left.right = new TreeNode(9);
        r.right.left = new TreeNode(10);
        r.right.right = new TreeNode(11);
        r.left.left.left = new TreeNode(12);

        List<Integer> res = new ArrayList<>();
        BinaryTreeDFS.findRootToLeafPathNumber(r, 0, res);
        res.stream().forEach(s -> System.out.print(s + " "));

    }

}
