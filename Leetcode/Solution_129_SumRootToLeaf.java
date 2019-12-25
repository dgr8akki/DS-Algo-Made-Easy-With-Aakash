package Leetcode;

class Solution_129_SumRootToLeaf {
  public int sumNumbers(TreeNode root) {
    return sumRootToLeaf(root, 0);
  }

  public int sumRootToLeaf(TreeNode n, int s) {
    if (n == null)
      return 0;
    if (n.right == null && n.left == null)
      return s * 10 + n.val;
    return sumRootToLeaf(n.left, s * 10 + n.val) + sumRootToLeaf(n.right, s * 10 + n.val);
  }
}
