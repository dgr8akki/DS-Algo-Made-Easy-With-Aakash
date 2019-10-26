package Leetcode;

class Solution {
  ListNode head;

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    ListNode temp = l1;
    while (temp != null) {
      s1.push(temp.val);
      temp = temp.next;
    }
    temp = l2;
    while (temp != null) {
      s2.push(temp.val);
      temp = temp.next;
    }

    int carry = 0;
    while (!s1.isEmpty() || !s2.isEmpty()) {
      int val1 = s1.isEmpty() ? 0 : s1.pop();
      int val2 = s2.isEmpty() ? 0 : s2.pop();
      int v = (val1 + val2 + carry) % 10;
      carry = (val1 + val2 + carry) / 10;
      addAtHead(v);
    }
    if (carry > 0)
      addAtHead(carry);

    return head;
  }

  public void addAtHead(int val) {
    ListNode nodeAtIndex = head;
    ListNode node = new ListNode(val);
    if (nodeAtIndex == null)
      head = node;
    else {
      node.next = head;
      head = node;
    }
  }
}
