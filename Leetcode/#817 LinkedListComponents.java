/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public int numComponents(ListNode head, int[] G) {
    Set<Integer> setG = new HashSet<>();
    for (int i : G)
      setG.add(i);
    int res = 0;
    while (head != null) {
      if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val)))
        res++;
      head = head.next;
    }
    return res;
  }
}
