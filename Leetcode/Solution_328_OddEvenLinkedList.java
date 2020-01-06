package Leetcode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution_328_OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    if (head.next.next == null)
      return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenhead = even;
    while (even != null && even.next != null) {
      odd.next = odd.next.next;
      even.next = even.next.next;
      odd = odd.next;
      even = even.next;
    }
    odd.next = evenhead;
    return head;
  }
}
