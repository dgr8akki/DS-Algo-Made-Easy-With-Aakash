package Hackerrank.Practise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ComponentsInAGraph {

  private static final Scanner scanner = new Scanner(System.in);
  private final Map<Integer, Node> hm = new HashMap<>();

  private static int[] componentsInGraph(ComponentsInAGraph solution) {
    int[] res = new int[2];
    res[0] = Integer.MAX_VALUE;
    res[1] = Integer.MIN_VALUE;
    for (int el : solution.hm.keySet()) {
      int size = solution.findSet(solution.hm.get(el)).commSize;
      if (size > res[1]) {
        res[1] = size;
      }
      if (size < res[0]) {
        res[0] = size;
      }
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(ComponentsInAGraph.scanner.nextLine().trim());
    ComponentsInAGraph solution = new ComponentsInAGraph();
    int[][] gb = new int[n][2];
    for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
      String[] gbRowItems = ComponentsInAGraph.scanner.nextLine().split(" ");

      for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
        int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
        gb[gbRowItr][gbColumnItr] = gbItem;
      }
    }

    for (int i = 0; i < n; i++) {
      solution.unionNewNodes(gb[i][0], gb[i][1]);
    }

    int[] result = ComponentsInAGraph.componentsInGraph(solution);

    System.out.print(
        "Min connected components are: "
            + result[0]
            + " and Maximum connected componentsa are: "
            + result[1]);
  }

  private void makeSet(int val) {
    hm.put(val, new Node(val));
  }

  private void unionNewNodes(int a, int b) {
    if (!hm.containsKey(a)) {
      makeSet(a);
    }
    if (!hm.containsKey(b)) {
      makeSet(b);
    }

    union(a, b);
  }

  public void union(int a, int b) {
    Node nodeA = hm.get(a);
    Node nodeB = hm.get(b);

    Node parentA = findSet(nodeA);
    Node parentB = findSet(nodeB);

    if (parentA.value == parentB.value) {
      return;
    }

    if (parentA.rank >= parentB.rank) {
      parentA.rank = (parentA.rank == parentB.rank) ? parentA.rank + 1 : parentA.rank;
      parentB.parent = parentA;
      parentA.commSize += parentB.commSize;
    } else {
      parentA.parent = parentB;
      parentB.commSize += parentA.commSize;
    }
  }

  public int query(int value) {
    return findSet(hm.get(value)).commSize;
  }

  private Node findSet(Node node) {
    Node parent = node.parent;
    if (parent == node) {
      return parent;
    }
    node.parent = findSet(node.parent);
    return node.parent;
  }

  class Node {
    int value;
    int rank;
    Node parent;
    int commSize;

    Node(int v) {
      value = v;
      rank = 0;
      parent = this;
      commSize = 1;
    }
  }
}
