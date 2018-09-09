/*
class Node {
  int data;
  Node left;
  Node right;

  Node(int val) {
    data = val;
  }
}
*/
class Solution {
  static void inorder(Node root, ArrayList<Integer> list) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(root.data);
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
  static boolean checkBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        if(list.size() <= 1) return true;
        for(int i = 1; i <= list.size() - 1; i++)
            if(list.get(i) <= list.get(i-1)) return false;
        return true;
    }
}
