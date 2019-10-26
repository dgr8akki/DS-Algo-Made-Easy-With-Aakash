package Leetcode;

class Solution {
  public ListNode sortList(ListNode head) {
    int length = 0;
    ListNode dummy = head;
    while (dummy != null) {
      length += 1;
      dummy = dummy.next;
    }
    if (length <= 1) {
      return head;
    }

    // split
    dummy = head;
    for (int i = 0; i < length / 2 - 1; i++) {
      dummy = dummy.next;
    }
    ListNode tail = dummy.next;
    dummy.next = null;

    ListNode left = sortList(head);
    ListNode right = sortList(tail);

    return merge(left, right);
  }

  private ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0);
    ListNode cp = dummy;
    while (a != null & b != null) {
      if (a.val < b.val) {
        dummy.next = a;
        a = a.next;
        dummy = dummy.next;
      } else {
        dummy.next = b;
        b = b.next;
        dummy = dummy.next;
      }
    }
    if (a != null) {
      dummy.next = a;
    } else {
      dummy.next = b;
    }
    return cp.next;
  }
}
