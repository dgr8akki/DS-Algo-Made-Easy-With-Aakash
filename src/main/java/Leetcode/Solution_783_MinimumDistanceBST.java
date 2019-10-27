package Leetcode;

class Solution_783_MinimumDistanceBST {
  int min = Integer.MAX_VALUE;
  int prev = -1;

  public int minDiffInBST(TreeNode root) {
    if (root == null)
      return min;

    minDiffInBST(root.left);

    if (prev != -1) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;

    minDiffInBST(root.right);

    return min;
  }
}
