package Leetcode;

class Solution {
  int sum = 0;

  public TreeNode bstToGst(TreeNode root) {
    if (root == null)
      return null;
    bstToGst(root.right);
    sum += root.val;
    root.val = sum;
    bstToGst(root.left);
    return root;
  }
}
