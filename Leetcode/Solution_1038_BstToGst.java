package Leetcode;

class Solution_1038_BstToGst {
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
