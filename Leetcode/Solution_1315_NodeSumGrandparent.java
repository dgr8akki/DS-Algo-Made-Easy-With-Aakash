/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int sumEvenGrandparent(TreeNode root) {
    return calculate(root, false, false);
  }

  private int calculate(TreeNode root, boolean parentEven, boolean grandparentEven) {
    if (root == null) {
      return 0;
    }

    return (grandparentEven ? root.val : 0) + calculate(root.left, root.val % 2 == 0 ? true : false, parentEven)
        + calculate(root.right, root.val % 2 == 0 ? true : false, parentEven);
  }
}
