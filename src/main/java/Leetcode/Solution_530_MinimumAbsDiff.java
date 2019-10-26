package Leetcode;

public class Solution {
  int min = Integer.MAX_VALUE;
  int prev = -1;

  public int getMinimumDifference(TreeNode root) {
    if (root == null)
      return min;

    getMinimumDifference(root.left);

    if (prev != -1) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;

    getMinimumDifference(root.right);

    return min;
  }
}
