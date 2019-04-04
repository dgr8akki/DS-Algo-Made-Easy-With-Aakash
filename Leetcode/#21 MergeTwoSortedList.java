/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = null, ptr = null;
    if (l1 == null && l2 == null)
      return null;
    if (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        head = l1;
        l1 = l1.next;
      } else {
        head = l2;
        l2 = l2.next;
      }
      head.next = null;
    } else if (l1 != null && l2 == null) {
      head = l1;
      l1 = l1.next;
      head.next = null;
    } else if (l1 == null && l2 != null) {
      head = l2;
      l2 = l2.next;
      head.next = null;
    }
    ptr = head;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        ptr.next = l1;
        l1 = l1.next;
      } else {
        ptr.next = l2;
        l2 = l2.next;
      }
      ptr = ptr.next;
    }
    while (l1 != null) {
      ptr.next = l1;
      l1 = l1.next;
      ptr = ptr.next;
    }
    while (l2 != null) {
      ptr.next = l2;
      l2 = l2.next;
      ptr = ptr.next;
    }
    return head;
  }
}
