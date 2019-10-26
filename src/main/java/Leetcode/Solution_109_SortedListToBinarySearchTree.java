package Leetcode;

class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return new TreeNode(head.val);
    ListNode slowRunner = getMidNodeList(head);
    TreeNode node = new TreeNode(slowRunner.val);
    node.left = sortedListToBST(head);
    node.right = sortedListToBST(slowRunner.next);
    return node;
  }

  private ListNode getMidNodeList(ListNode head) {
    ListNode slow = head, fast = head;
    ListNode pre = null;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;

    return slow;
  }
}
