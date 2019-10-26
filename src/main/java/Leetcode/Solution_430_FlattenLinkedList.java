package Leetcode;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
  public Node flatten(Node head) {
    flattenTail(head);
    return head;
  }

  private Node flattenTail(Node head) {
    if (head == null)
      return head;
    if (head.child == null) {
      if (head.next == null)
        return head;
      return flattenTail(head.next);
    } else {
      Node child = head.child;
      head.child = null;
      Node next = head.next;
      Node childtail = flattenTail(child);
      head.next = child;
      child.prev = head;
      if (next != null) {
        childtail.next = next;
        next.prev = childtail;
        return flattenTail(next);
      }
      return childtail;
    }
  }
}
