

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.tree;


class NodeWithParent {
  int data;
  NodeWithParent left, right, parent;

  NodeWithParent(int data) {
    this.data = data;
    left = right = parent = null;
  }
}

