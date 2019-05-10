class Solution {
  public int countNodes(TreeNode root) {

    int leftDepth = leftDepth(root);
    int rightDepth = rightDepth(root);

    if (leftDepth == rightDepth)
      return (1 << leftDepth) - 1;
    else
      return 1 + countNodes(root.left) + countNodes(root.right);

  }

  private int rightDepth(TreeNode root) {
    int dep = 0;
    while (root != null) {
      root = root.right;
      dep++;
    }
    return dep;
  }

  private int leftDepth(TreeNode root) {
    int dep = 0;
    while (root != null) {
      root = root.left;
      dep++;
    }
    return dep;
  }
}
