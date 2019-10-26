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
    public List<Integer> postorder(Node root) {
        List<Integer> list =  new ArrayList<>();
        if(root == null) return list;
        Stack<Node> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()) {
          Node current = st.pop();
          list.add(current.val);
          for(Node child: current.children) {
            st.add(child);
          }
        }
      Collections.reverse(list);
      return list;
    }
}