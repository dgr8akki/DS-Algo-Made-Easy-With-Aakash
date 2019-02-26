import java.util.Arrays;
import java.util.Scanner;

/**
 * HorribleQueries
 */
public class HorribleQueries {
  long[] arr;
  private long[] tree;
  private long[] lazy;

  HorribleQueries(int n) {
    this.arr = new long[n];
    this.tree = new long[4 * this.arr.length];
    this.lazy = new long[4 * this.arr.length];
  }

  public void update(int leftIndex, int rightIndex, long incrementBy) {
    update(0, this.arr.length, 1, leftIndex, rightIndex, incrementBy);
  }

  private void update(int start, int end, int treeNode, int leftIndex, int rightIndex, long inc) {
    if (start > end)
      return;
    if (lazy[treeNode] != 0) {
      tree[treeNode] += (lazy[treeNode] * (end - start + 1));
      if (start != end) {
        lazy[2 * treeNode] += lazy[treeNode];
        lazy[(2 * treeNode) + 1] += lazy[treeNode];
      }
      lazy[treeNode] = 0;
    }

    if (leftIndex > end || rightIndex < start)
      return;
    if (leftIndex <= start && end <= rightIndex) {
      tree[treeNode] += (inc * (end - start + 1));
      if (start != end) {
        lazy[2 * treeNode] += inc;
        lazy[(2 * treeNode) + 1] += inc;
      }
      return;
    }
    int mid = (start + end) / 2;
    update(start, mid, 2 * treeNode, leftIndex, rightIndex, inc);
    update(mid + 1, end, (2 * treeNode) + 1, leftIndex, rightIndex, inc);
    tree[treeNode] = tree[2 * treeNode] + tree[(2 * treeNode) + 1];
  }

  public long query(int startingIndex, int endIndex) {
    return query(0, this.arr.length, 1, startingIndex, endIndex);
  }

  private long query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    if (lazy[treeNode] != 0) {
      tree[treeNode] += (lazy[treeNode] * (end - start + 1));
      if (start != end) {
        lazy[2 * treeNode] += lazy[treeNode];
        lazy[(2 * treeNode) + 1] += lazy[treeNode];
      }
      lazy[treeNode] = 0;
    }
    // Fully outside
    if (startingIndex > end || endIndex < start)
      return 0;
    // Fully overlap
    if (startingIndex <= start && endIndex >= end)
      return tree[treeNode];
    // Partially overlap
    int mid = (start + end) / 2;
    long leftSum = query(start, mid, 2 * treeNode, startingIndex, endIndex);
    long rightSum = query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex);
    return leftSum + rightSum;
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
    System.out.println(Arrays.toString(this.lazy));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int c = in.nextInt();
      HorribleQueries queries = new HorribleQueries(n);
      while (c-- > 0) {
        int type = in.nextInt();
        if (type == 0) {
          int p = in.nextInt();
          int q = in.nextInt();
          int v = in.nextInt();
          queries.update(p, q, v);
        } else {
          int p = in.nextInt();
          int q = in.nextInt();
          System.out.println(queries.query(p, q));
        }
      }
      // queries.print();
    }
    in.close();
  }
}
