package Leetcode;

public class Solution_142_LinkedListCycle {
  public ListNode detectCycle(ListNode head) {
    ListNode slowRunner = head;
    ListNode fastRunner = head;

    while (fastRunner != null && fastRunner.next != null) {
      fastRunner = fastRunner.next.next;
      slowRunner = slowRunner.next;

      if (fastRunner == slowRunner) {
        ListNode slow = head;
        while (slow != slowRunner) {
          slowRunner = slowRunner.next;
          slow = slow.next;
        }
        return slowRunner;
      }
    }
    return null;
  }
}
