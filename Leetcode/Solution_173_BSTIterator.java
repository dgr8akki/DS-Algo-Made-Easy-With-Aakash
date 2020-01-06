package Leetcode;

import java.util.Stack;

class Solution_173_BSTIterator {
  private final Stack<TreeNode> stack = new Stack<>();

  public Solution_173_BSTIterator(TreeNode root) {
    pushAll(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode tmpNode = stack.pop();
    pushAll(tmpNode.right);
    return tmpNode.val;
  }

  private void pushAll(TreeNode node) {
    for (; node != null; stack.push(node), node = node.left) {}
  }
}
