/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int result = 0;

  public int distributeCoins(TreeNode root) {
    dfsUtil(root);
    return result;
  }

  public int dfsUtil(TreeNode root) {
    if (root == null)
      return 0;
    int left = dfsUtil(root.left);
    int right = dfsUtil(root.right);
    result += Math.abs(left) + Math.abs(right);
    return root.val + left + right - 1;
  }
}
