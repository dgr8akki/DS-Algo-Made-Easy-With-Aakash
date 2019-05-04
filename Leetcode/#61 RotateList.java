class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null)
      return head;
    ListNode temp = new ListNode(0);
    temp.next = head;
    ListNode fast = temp, slow = temp;

    int i;
    // Get the total length in i
    for (i = 0; fast.next != null; i++)
      fast = fast.next;

    // Get the i - k % i th node
    for (int j = i - k % i; j > 0; j--)
      slow = slow.next;

    fast.next = temp.next;
    temp.next = slow.next;
    slow.next = null;
    return temp.next;
  }
}
