class Solution {
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    return traverse(root, target);
  }

  private TreeNode traverse(TreeNode node, int target) {
    if (node == null)
      return null;
    node.left = traverse(node.left, target);
    node.right = traverse(node.right, target);

    if (node.left == null && node.right == null && node.val == target)
      return null;
    else
      return node;
  }
}
