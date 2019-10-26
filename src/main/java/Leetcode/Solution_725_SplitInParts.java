package Leetcode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    int N = 0;
    for (ListNode cur = root; cur != null; cur = cur.next)
      N++;
    int size = N / k, extra1 = N - k * size;
    ListNode[] A = new ListNode[k];

    for (int i = 0; i < k; i++) {
      A[i] = root;
      ListNode X = null;
      for (int j = size + (i < extra1 ? 1 : 0); j > 0; j--, root = root.next)
        X = root;
      if (X != null)
        X.next = null;
    }

    return A;
  }
}
