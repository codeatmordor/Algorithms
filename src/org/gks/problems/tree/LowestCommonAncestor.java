
// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;

public class LowestCommonAncestor {

    static Node root;

    static Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    static Node findLCA(Node n, int n1, int n2) {
        if (n == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (n.data == n1 || n.data == n2)
            return n;

        Node left_lca = findLCA(n.left, n1, n2);
        Node right_lca = findLCA(n.right, n1, n2);

        if (left_lca != null && right_lca != null)
            return n;
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        root = tree.root;
        System.out.println(findLCA(5, 6).data);
    }
}
