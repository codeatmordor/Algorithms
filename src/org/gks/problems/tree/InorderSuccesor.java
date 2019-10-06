

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;



public class InorderSuccesor {
  static NodeWithParent root;

  NodeWithParent insert(NodeWithParent n, int data) {
    if (n == null) {
      return new NodeWithParent(data);
    } else {
      NodeWithParent temp = null;
      if (data <= n.data) {
        temp = insert(n.left, data);
        n.left = temp;
        temp.parent = n;
      } else {
        temp = insert(n.right, data);
        n.right = temp;
        temp.parent = n;
      }
    }
    return n;
  }

  NodeWithParent inOrderSuccessor(NodeWithParent root, NodeWithParent node) {
    if (node.right != null) {
      return leftMostChild(node.right);
    }

    NodeWithParent p = node.parent;
    while (p != null && node == p.right) {
      node = p;
      p = p.parent;
    }
    return p;
  }



  NodeWithParent leftMostChild(NodeWithParent n) {
    NodeWithParent current = n;
    while (current.left != null) {
      current = current.left;
    }
    return current;
  }

  public static void main(String[] args) {
    InorderSuccesor tree = new InorderSuccesor();
    NodeWithParent root = null, temp = null, suc = null, min = null;
    root = tree.insert(root, 20);
    root = tree.insert(root, 8);
    root = tree.insert(root, 22);
    root = tree.insert(root, 4);
    root = tree.insert(root, 12);
    root = tree.insert(root, 10);
    root = tree.insert(root, 14);
    temp = root.left.right.right;
    suc = tree.inOrderSuccessor(root, temp);
    if (suc != null) {
      System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
    } else {
      System.out.println("Inorder successor does not exist");
    }
  }

}

