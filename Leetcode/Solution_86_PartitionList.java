package Leetcode;

class Solution_86_PartitionList {
  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;
    ListNode temp1 = new ListNode(0);
    ListNode temp2 = new ListNode(0);
    ListNode curr2 = temp2, curr1 = temp1;
    while (head != null) {
      if (head.val < x) {
        curr1.next = head;
        curr1 = head;
      } else {
        curr2.next = head;
        curr2 = head;
      }
      head = head.next;
    }
    curr2.next = null;
    curr1.next = temp2.next;
    return temp1.next;
  }
}
