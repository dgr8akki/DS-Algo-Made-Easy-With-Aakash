package Leetcode;

import java.util.Random;

public class Solution_382_RandomNodeLinkedList {

  private ListNode head;
  private Random random;

  public Solution_382_RandomNodeLinkedList(ListNode h) {
    head = h;
    random = new Random();
  }

  public int getRandom() {

    ListNode current = head;
    int result = current.val;
    for (int i = 1; current.next != null; i++) {
      current = current.next;
      if (random.nextInt(i + 1) == i) {
        result = current.val;
      }
    }
    return result;
  }
}
