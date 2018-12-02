import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
  private int maxCapacity;
  private Map<Integer, Node> map = new HashMap<>();
  private LinkedList<Node> list = new LinkedList<>();

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
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(5);
  }
}
