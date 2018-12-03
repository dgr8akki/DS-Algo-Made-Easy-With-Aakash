import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
  private int maxCapacity;
  private Map<Integer, Node> map = new HashMap<>();
  private Node tail, head;

  private static class Node {
    private Node next, prev;
    public int key;
    public String value;

    public Node(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public LRUCache(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public String getValue(int key) {
    Node node = map.get(key);

    if(node == null) return null;

    if(node != head) {
      removeNodeFromLList(node);
      insertAtBegining(node);
    }
    return node.value;
  }

  public void print() {
    System.out.println(map);
  }

  private void removeNodeFromLList(Node node) {
    if(node == null) return;
    if(node.prev != null) node.prev.next = node.next;
    if(node.next != null) node.next.prev = node.prev;
    if(node == tail) tail = node.prev;
    if(node == head) head = node.next;
  }

  private void insertAtBegining(Node node) {
    if(head == null) {
      head = node;
      tail = node;
    } else {
      head.prev = node;
      node.next = head;
      head = node;
    }
  }

  public void removeKey(int key) {
    Node node = map.get(key);
    removeNodeFromLList(node);
    map.remove(key);
  }

  public void setKeyValue(int key, String value) {
    removeKey(key);

    if (map.size() >= maxCapacity && tail != null) {
      removeKey(tail.key);
    }

    Node node = new Node(key, value);
    insertAtBegining(node);
    map.put(key, node);
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(5);
    cache.setKeyValue(3, "3");
    cache.setKeyValue(4, "4");
    cache.setKeyValue(12, "12");
    cache.setKeyValue(12, "12");
    cache.setKeyValue(6, "6");
    cache.setKeyValue(7, "7");
    cache.setKeyValue(6, "6");
    cache.setKeyValue(1, "1");
    cache.print();
  }
}
