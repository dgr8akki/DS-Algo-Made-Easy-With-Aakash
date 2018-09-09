import java.util.Map;
import java.util.HashMap;

public class DisjointSet {

  class Node {
    long value;
    int rank;
    Node parent;

    Node(long v) {
      this.value = v;
      this.rank = 0;
      this.parent = this;
    }
  }

  private Map<Long, Node> hm = new HashMap<>();

  public void makeSet(long val) {
    hm.put(val, new Node(val));
  }

  public void union(long a, long b) {
    Node nodeA = hm.get(a);
    Node nodeB = hm.get(b);

    Node parentA = findSet(nodeA);
    Node parentB = findSet(nodeB);

    if(parentA.value == parentB.value) return;

    if(parentA.rank >= parentB.rank) {
      parentA.rank = ( parentA.rank == parentB.rank ) ? parentA.rank + 1 : parentA.rank;
      parentB.parent = parentA;
    } else
        parentA.parent = parentB;
  }

  public long findSet(long value) {
    return findSet(hm.get(value)).value;
  }

  private Node findSet(Node node) {
    Node parent = node.parent;
    if(parent == node) return parent;
    node.parent = findSet(node.parent);
    return node.parent;
  }

  public static void main(String args[]) {
    DisjointSet ds = new DisjointSet();
    ds.makeSet(1);
    ds.makeSet(2);
    ds.makeSet(3);
    ds.makeSet(4);
    ds.makeSet(5);
    ds.makeSet(6);
    ds.makeSet(7);

    ds.union(1, 2);
    ds.union(2, 3);
    ds.union(4, 5);
    ds.union(6, 7);
    ds.union(5, 6);
    ds.union(3, 7);

    System.out.println(ds.findSet(1));
    System.out.println(ds.findSet(2));
    System.out.println(ds.findSet(3));
    System.out.println(ds.findSet(4));
    System.out.println(ds.findSet(5));
    System.out.println(ds.findSet(6));
    System.out.println(ds.findSet(7));
  }
}
