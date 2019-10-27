package Leetcode;

class Solution_102_BinaryTreeLevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> mainQueue = new LinkedList<>();
    Queue<TreeNode> tempQueue = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (root == null) {
      return ans;
    }
    mainQueue.add(root);
    while (mainQueue.size() != 0) {
      List<Integer> level = new ArrayList<Integer>();
      while (mainQueue.size() != 0) {
        tempQueue.add(mainQueue.remove());
      }
      while (tempQueue.size() != 0) {
        TreeNode node = tempQueue.remove();
        level.add(node.val);
        if (node.left != null)
          mainQueue.add(node.left);
        if (node.right != null)
          mainQueue.add(node.right);
      }
      ans.add(level);
    }
    return ans;
  }
}
