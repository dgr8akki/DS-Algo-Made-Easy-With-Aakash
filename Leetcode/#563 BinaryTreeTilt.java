/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int findTilt(TreeNode root) {
    int selfTilt = 0, leftTilt = 0, rightTilt = 0;
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 0;
    if (root.left == null && root.right != null) {
      rightTilt = findTilt(root.right);
      selfTilt = Math.abs(root.right.val);
    } else if (root.left != null && root.right == null) {
      leftTilt = findTilt(root.left);
      selfTilt = Math.abs(root.left.val);
    } else if (root.left != null && root.right != null) {
      rightTilt = findTilt(root.right);
      leftTilt = findTilt(root.left);
      selfTilt = Math.abs(root.left.val - root.right.val);
    }

    System.out.println(selfTilt);
    return selfTilt + leftTilt + rightTilt;
  }
}
