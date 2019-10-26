package Leetcode;

class Solution {
  int res = 0;

  public int findTilt(TreeNode root) {
    if (root == null)
      return 0;
    findTiltUtil(root);
    return res;
  }

  public int findTiltUtil(TreeNode root) {
    int selfTilt = 0, leftTilt = 0, rightTilt = 0;
    if (root == null)
      return 0;
    selfTilt = root.val;
    leftTilt = findTiltUtil(root.left);
    rightTilt = findTiltUtil(root.right);
    res += Math.abs(leftTilt - rightTilt);
    return selfTilt + leftTilt + rightTilt;
  }
}
