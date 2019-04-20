/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> mainQueue = new LinkedList<>();
    Queue<TreeNode> tempQueue = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
    return ans.get(ans.size() - 1).get(0);
  }
}
