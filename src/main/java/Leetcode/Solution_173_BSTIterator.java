package Leetcode;

public class BSTIterator {
  private Stack<TreeNode> stack = new Stack<TreeNode>();

  public BSTIterator(TreeNode root) {
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
    for (; node != null; stack.push(node), node = node.left)
      ;
  }
}
