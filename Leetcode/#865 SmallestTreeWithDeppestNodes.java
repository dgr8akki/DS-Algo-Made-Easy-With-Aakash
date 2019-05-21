class Solution {
  public int depth(TreeNode root) {
    if (root == null)
      return 0;
    return Math.max(depth(root.left), depth(root.right)) + 1;
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    if (root == null)
      return null;
    int left = depth(root.left);
    int right = depth(root.right);
    if (left == right)
      return root;
    if (left > right)
      return subtreeWithAllDeepest(root.left);
    return subtreeWithAllDeepest(root.right);
  }
}
