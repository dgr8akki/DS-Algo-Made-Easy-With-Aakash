/**
 * FirstUnique
 */
class FirstUnique {
  private final ListNode head = new ListNode(999);
  private final ListNode tail = new ListNode(999);
  private final Map<Integer, ListNode> map;
  private int nodesCount;

  public FirstUnique(int[] nums) {
    this.map = new HashMap<>();
    head.next = tail;
    tail.previous = head;
    this.nodesCount = 0;

    for (int num : nums)
      this.add(num);
  }

  public void add(int num) {
    if (map.containsKey(num)) {
      ListNode node = map.get(num);
      deleteNode(node);
    } else {
      ListNode newNode = new ListNode(num);
      map.put(num, newNode);
      insertAtTheTail(newNode);
    }
  }

  private void deleteNode(ListNode node) {
    ListNode next = node.next;
    ListNode previous = node.previous;
    if (previous != null && next != null) {
      previous.next = next;
      next.previous = previous;
      node.next = null;
      node.previous = null;
      nodesCount--;
    }
  }

  private void insertAtTheTail(ListNode newNode) {
    ListNode previous = tail.previous;
    newNode.previous = previous;
    previous.next = newNode;
    newNode.next = tail;
    tail.previous = newNode;
    nodesCount++;
  }

  private boolean isEmpty() {
    return nodesCount == 0;
  }

  class ListNode {
    final int value;
    ListNode next;
    ListNode previous;

    ListNode(int value) {
      this.value = value;
    }
  }

  public int showFirstUnique() {
    if (isEmpty())
      return -1;
    return head.next.value;
  }
}
