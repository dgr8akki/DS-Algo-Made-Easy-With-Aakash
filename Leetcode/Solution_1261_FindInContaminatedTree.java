/**
 * Solution_1261_FindInContaminatedTree
 */
public class Solution_1261_FindInContaminatedTree {

  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode
   * left; TreeNode right; TreeNode(int x) { val = x; } }
   */
  class FindElements {
    TreeNode root = null;

    public FindElements(TreeNode root) {
      this.root = root;

      recoverTree(root, 0);
    }

    public boolean find(int target) {
      return find(root, target);
    }

    private boolean find(TreeNode root, int target) {
      if (root == null)
        return false;

      if (root.val == target)
        return true;

      return find(root.left, target) || find(root.right, target);
    }

    private void recoverTree(TreeNode root, int parentValue) {
      if (root == null)
        return;

      root.val = parentValue;

      recoverTree(root.left, (2 * parentValue) + 1);
      recoverTree(root.right, (2 * parentValue) + 2);
    }
  }

  /**
   * Your FindElements object will be instantiated and called as such:
   * FindElements obj = new FindElements(root); boolean param_1 =
   * obj.find(target);
   */
}
