class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null)
      return null;
    ListNode start = new ListNode(-1);
    start.next = head;
    ListNode comitted = start;
    ListNode previous = head;
    boolean wasDup = false;
    for (ListNode cursor = head.next; cursor != null; previous = cursor, cursor = cursor.next) {
      if (cursor.val == previous.val) {
        wasDup = true;
      } else {
        if (!wasDup) {
          comitted.next = previous;
          comitted = previous;
        }
        wasDup = false;
      }
    }
    comitted.next = wasDup ? null : previous;
    return start.next;
  }
}
