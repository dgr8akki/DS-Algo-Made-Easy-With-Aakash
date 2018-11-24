import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
  private Map<Integer, Node> store;
  class Node {
    int data;
    int rank;
    Node parent;

    Node(int data) {
      this.data = data;
      rank = 0;
      parent = this;
    }
  }

  DisjointSet() {
    store = new HashMap<>();
  }

  public void makeSet(int data) {
    store.put(data, new Node(data));
  }

  public void union(int data1, int data2) {
    Node node1 = store.get(data1);
    Node node2 = store.get(data2);

    Node parent1 = findSet(node1);
    Node parent2 = findSet(node2);

    if(parent1.data == parent2.data) return;
    if(parent1.rank >= parent2.rank) {
      parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
      parent2.parent = parent1;
    } else {
      parent1.parent = parent2;
    }
  }

  public int findSet(int data) {
    return findSet(store.get(data)).data;
  }

  public Node findSet(Node dataNode) {
    Node parent = dataNode.parent;
    if(parent == dataNode) return parent;
    dataNode.parent = findSet(dataNode.parent);
    return dataNode.parent;
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
