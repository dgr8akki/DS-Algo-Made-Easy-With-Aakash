package Leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<Integer> largestValues(TreeNode root) {
    Queue<TreeNode> mainQueue = new LinkedList<>();
    Queue<TreeNode> tempQueue = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    mainQueue.add(root);
    while (mainQueue.size() != 0) {
      List<Integer> level = new ArrayList<Integer>();
      int max = Integer.MIN_VALUE;
      while (mainQueue.size() != 0) {
        tempQueue.add(mainQueue.remove());
      }
      while (tempQueue.size() != 0) {
        TreeNode node = tempQueue.remove();
        level.add(node.val);
        max = Math.max(max, node.val);
        if (node.left != null)
          mainQueue.add(node.left);
        if (node.right != null)
          mainQueue.add(node.right);
      }
      ans.add(max);
    }
    return ans;
  }
}
