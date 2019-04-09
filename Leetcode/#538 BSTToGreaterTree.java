/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root == null)
      return null;
    convertBST(root.right);
    root.val += sum;
    sum = root.val;
    convertBST(root.left);

    return root;
  }
}