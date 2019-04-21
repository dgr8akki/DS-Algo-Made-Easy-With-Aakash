class Solution {
  public int rangeSumBST(TreeNode root, int L, int R) {
    if (root == null)
      return 0;
    int leftSum = 0, rightSum = 0;
    if (root.val >= L) {
      leftSum = rangeSumBST(root.left, L, R);
    }
    if (root.val <= R) {
      rightSum = rangeSumBST(root.right, L, R);
    }
    int nodeVal = (root.val >= L && root.val <= R) ? root.val : 0;
    return leftSum + rightSum + nodeVal;
  }
}
