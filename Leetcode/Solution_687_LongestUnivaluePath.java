package Leetcode;

class Solution_687_LongestUnivaluePath {
  int res = 0;

  public int longestUnivaluePath(TreeNode root) {
    longestUnivaluePathUtil(root);
    return res;
  }

  private int longestUnivaluePathUtil(TreeNode root) {
    if (root == null)
      return 0;
    int left = longestUnivaluePathUtil(root.left);
    int right = longestUnivaluePathUtil(root.right);
    int leftMax = 0, rightMax = 0;
    if (root.left != null && root.left.val == root.val) {
      leftMax += left + 1;
    }

    if (root.right != null && root.right.val == root.val) {
      rightMax += right + 1;
    }
    res = Math.max(res, rightMax + leftMax);
    return Math.max(rightMax, leftMax);
  }
}
