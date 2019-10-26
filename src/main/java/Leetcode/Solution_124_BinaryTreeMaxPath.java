package Leetcode;

public class Solution {
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathSumUtil(root);
    return max;
  }

  private int maxPathSumUtil(TreeNode root) {
    if (root == null)
      return 0;

    int left = Math.max(maxPathSumUtil(root.left), 0);
    int right = Math.max(maxPathSumUtil(root.right), 0);

    max = Math.max(max, root.val + left + right);

    return root.val + Math.max(left, right);
  }
}
