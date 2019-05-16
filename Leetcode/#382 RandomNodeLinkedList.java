public class Solution {

  ListNode head;
  Random random;

  public Solution(ListNode h) {
    head = h;
    random = new Random();
  }

  public int getRandom() {

    ListNode current = head;
    int result = current.val;
    for (int i = 1; current.next != null; i++) {
      current = current.next;
      if (random.nextInt(i + 1) == i)
        result = current.val;
    }
    return result;
  }
}
