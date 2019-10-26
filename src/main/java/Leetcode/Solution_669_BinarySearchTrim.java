package Leetcode;

class Solution {

  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null)
      return null;
    TreeNode left = trimBST(root.left, L, R);
    TreeNode right = trimBST(root.right, L, R);
    if (root.val < L || root.val > R) {
      if (left == null && right == null)
        return null;
      if (left != null && right != null) {
        while (right.left != null) {
          right = right.left;
        }
        right.left = left;
        return left;
      }
      if (left != null)
        return left;
      if (right != null)
        return right;
      return null;
    } else {
      root.left = left;
      root.right = right;
      return root;
    }
  }
}
