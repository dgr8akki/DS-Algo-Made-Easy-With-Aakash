package Leetcode;

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = new ListNode(0);
    ListNode fastRunner = temp, slowRunner = temp;
    slowRunner.next = head;
    for (int i = 0; i <= n; i++)
      fastRunner = fastRunner.next;
    while (fastRunner != null) {
      fastRunner = fastRunner.next;
      slowRunner = slowRunner.next;
    }
    slowRunner.next = slowRunner.next.next;
    return temp.next;
  }
}
