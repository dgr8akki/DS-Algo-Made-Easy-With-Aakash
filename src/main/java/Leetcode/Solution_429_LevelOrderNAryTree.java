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
class Solution {
  public List<List<Integer>> levelOrder(Node root) {
    Queue<Node> mainQueue = new LinkedList<>();
    Queue<Node> tempQueue = new LinkedList<>();
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
        Node node = tempQueue.remove();
        level.add(node.val);
        for (Node child : node.children) {
          mainQueue.add(child);
        }
      }
      ans.add(level);
    }
    return ans;
  }
}
