package Leetcode;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    Map<Node, Node> nodeMap = new HashMap<>();
    Node newHead = new Node(0, null, null);
    Node tail = newHead, p = head;
    while (p != null) {
      tail.next = new Node(p.val, p.next, p.random);
      nodeMap.put(p, tail.next);
      tail = tail.next;
      p = p.next;
    }
    p = newHead.next;
    while (p != null) {
      p.random = nodeMap.get(p.random);
      p = p.next;
    }
    return newHead.next;
  }
}
