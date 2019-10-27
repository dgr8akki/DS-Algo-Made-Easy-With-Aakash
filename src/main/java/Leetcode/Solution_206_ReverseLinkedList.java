package Leetcode;

class Solution_206_ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}
