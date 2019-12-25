package CodingNinjas.AdvanceGraphs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * DisjointSet
 */
class DisjointSet {
  private int[] parent;
  private int[] rank;
  int colour[];
  private int n;
  private ArrayList<Integer> arr[];

  DisjointSet(int n) {
    this.n = n;
    parent = new int[n];
    rank = new int[n];
    colour = new int[n];
    arr = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new ArrayList<>();
      arr[i].add(i);
      parent[i] = i;
    }
  }

  private void makeSet() {
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  public void union(int data1, int data2, int value) {
    int parent1 = findSet(data1);
    int parent2 = findSet(data2);
    if (parent1 == parent2) {
      return;
    }
    if (rank[parent1] >= rank[parent2]) {
      parent[parent2] = parent1;
      rank[parent1] = rank[parent1] == rank[parent2] ? 1 + rank[parent1] : rank[parent1];
      if (colour[data1] == colour[data2] && value == 1 || colour[data1] != colour[data2] && value == 0) {
        for (int i : arr[parent2]) {
          if (colour[i] == 0) {
            colour[i] = 1;
          } else {
            colour[i] = 0;
          }
        }
      }
      arr[parent1].addAll(arr[parent2]);
    } else {
      parent[parent1] = parent2;
      if (colour[data1] == colour[data2] && value == 1 || colour[data1] != colour[data2] && value == 0) {
        for (int i : arr[parent1]) {
          if (colour[i] == 0) {
            colour[i] = 1;
          } else {
            colour[i] = 0;
          }
        }
      }
      arr[parent2].addAll(arr[parent1]);
    }
  }

  int findSet(int data) {
    if (data != parent[data]) {
      parent[data] = findSet(parent[data]);
    }
    return parent[data];
  }
}

/**
 * FillTheMatrix
 */
public class FillTheMatrix {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int q = in.nextInt();
      DisjointSet set = new DisjointSet(n);
      boolean notPossible = false;
      for (int i = 0; i < q; i++) {
        int first = in.nextInt() - 1;
        int second = in.nextInt() - 1;
        int val = in.nextInt();

        if (set.findSet(first) == set.findSet(second)) {
          if ((set.colour[first] == set.colour[second] && val==1 ) ||
              (set.colour[first] != set.colour[second] && val==0)) {
            notPossible = true;
          }
        } else {
          set.union(first, second, val);
        }
      }

      if (notPossible) {
        System.out.println("No");
      } else {
        System.out.println("Yes");
      }
    }
    in.close();
  }
}
