package Leetcode;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution_559_DepthOfNaryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children.size() == 0) return 1;
        int max = -1;
        for(Node child: root.children) {
          max = Math.max(max, maxDepth(child));
        }
      return max + 1;
    }
}