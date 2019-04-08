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
    public TreeNode increasingBST(TreeNode root) {
        return increasingBSTHelper(root, null);
    }
    private TreeNode increasingBSTHelper(TreeNode root, TreeNode ansRoot) {
        if(root == null) return ansRoot;
        TreeNode ans = increasingBSTHelper(root.left, root);  
        root.left = null;
        root.right = increasingBSTHelper(root.right, ansRoot);
        return ans;
    }
}