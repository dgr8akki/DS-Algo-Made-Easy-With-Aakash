/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
          while(current != null) {
            stack.push(current);
            current = current.left;
          }
          current = stack.pop();
          list.add(current.val);
          current = current.right;
        }
      return list;
    }
}