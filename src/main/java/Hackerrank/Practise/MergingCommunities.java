package Hackerrank.Practise;

import java.util.*;

class Solution {

  class Node {
    int value;
    int rank;
    Node parent;
    int commSize;

    Node(int v) {
      this.value = v;
      this.rank = 0;
      this.parent = this;
      this.commSize = 1;
    }
  }

  private Map<Integer, Node> hm = new HashMap<>();

  public void makeSet(int val) {
    hm.put(val, new Node(val));
  }

  public void union(int a, int b) {
    Node nodeA = hm.get(a);
    Node nodeB = hm.get(b);

    Node parentA = findSet(nodeA);
    Node parentB = findSet(nodeB);

    if (parentA.value == parentB.value)
      return;

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
    if (parent == node)
      return parent;
    node.parent = findSet(node.parent);
    return node.parent;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int q = sc.nextInt();

    Solution solution = new Solution();

    for (int index = 1; index <= n; index++)
      solution.makeSet(index);

    for (int j = 0; j < q; j++) {
      String queryType = sc.next();

      if(queryType.equals("Q")) {
        int i = sc.nextInt();
        System.out.println(solution.query(i));
      }
      else if(queryType.equals("M")) {
        int firstPerson = sc.nextInt();
        int secondPerson = sc.nextInt();
        solution.union(firstPerson, secondPerson);
      }
    }
  }
}
