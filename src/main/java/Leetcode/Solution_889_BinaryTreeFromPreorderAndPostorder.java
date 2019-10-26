package Leetcode;

class Solution {
  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    int len = pre.length, nodes = 0;
    if (len == 0)
      return null;
    TreeNode root = new TreeNode(pre[0]);
    if (len == 1)
      return root;

    for (int i = 0; i < len; i++)
      if (pre[1] == post[i])
        nodes = i + 1;

    root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, nodes + 1), Arrays.copyOfRange(post, 0, nodes));

    root.right = constructFromPrePost(Arrays.copyOfRange(pre, nodes + 1, len),
        Arrays.copyOfRange(post, nodes, len - 1));

    return root;
  }
}
