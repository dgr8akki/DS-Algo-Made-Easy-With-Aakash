import java.util.Arrays;
import java.util.Scanner;

/**
 * VasyaRhezo
 */
public class VasyaRhezo {
  int[] A;
  int[] B;
  private Node[] tree;

  class Node {
    int a = Integer.MIN_VALUE;
    int b = Integer.MAX_VALUE;
    int id = Integer.MAX_VALUE;

    @Override
    public String toString() {
      return "(" + a + ", " + b + ", " + id + ")";
    }
  }

  VasyaRhezo(int[] A, int[] B) {
    this.A = A;
    this.B = B;
    this.tree = new Node[4 * this.A.length];
    this.buildTree(0, A.length - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if (start == end) {
      tree[treeNode] = new Node();
      tree[treeNode].a = A[start];
      tree[treeNode].b = B[start];
      tree[treeNode].id = start;
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    Node left = tree[2 * treeNode];
    Node right = tree[(2 * treeNode) + 1];
    Node ans = new Node();
    if (left.a == right.a) {
      if (left.b == right.b) {
        if (left.id < right.id) {
          ans.a = left.a;
          ans.b = left.b;
          ans.id = left.id;
        } else {
          ans.a = right.a;
          ans.b = right.b;
          ans.id = right.id;
        }
      } else {
        if (left.b < right.b) {
          ans.a = left.a;
          ans.b = left.b;
          ans.id = left.id;
        } else {
          ans.a = right.a;
          ans.b = right.b;
          ans.id = right.id;
        }
      }
    } else {
      if (left.a > right.a) {
        ans.a = left.a;
        ans.b = left.b;
        ans.id = left.id;
      } else {
        ans.a = right.a;
        ans.b = right.b;
        ans.id = right.id;
      }
    }
    tree[treeNode] = ans;
  }

  public int query(int startingIndex, int endIndex) {
    Node res = query(0, this.A.length - 1, 1, startingIndex - 1, endIndex - 1);
    if (res == null)
      return -1;
    return res.id + 1;
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
  }

  private Node query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    // Fully outside
    if (startingIndex > end || endIndex < start)
      return new Node();
    // Fully overlap
    if (startingIndex <= start && endIndex >= end)
      return tree[treeNode];
    // Partially overlap
    int mid = (start + end) / 2;
    Node left = query(start, mid, 2 * treeNode, startingIndex, endIndex);
    Node right = query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex);
    Node ans = new Node();
    if (left.a == right.a) {
      if (left.b == right.b) {
        if (left.id < right.id) {
          ans.a = left.a;
          ans.b = left.b;
          ans.id = left.id;
        } else {
          ans.a = right.a;
          ans.b = right.b;
          ans.id = right.id;
        }
      } else {
        if (left.b < right.b) {
          ans.a = left.a;
          ans.b = left.b;
          ans.id = left.id;
        } else {
          ans.a = right.a;
          ans.b = right.b;
          ans.id = right.id;
        }
      }
    } else {
      if (left.a > right.a) {
        ans.a = left.a;
        ans.b = left.b;
        ans.id = left.id;
      } else {
        ans.a = right.a;
        ans.b = right.b;
        ans.id = right.id;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] A = new int[n];
    int[] B = new int[n];
    for (int i = 0; i < n; i++)
      A[i] = in.nextInt();
    for (int i = 0; i < n; i++)
      B[i] = in.nextInt();
    VasyaRhezo vasyaRhezo = new VasyaRhezo(A, B);
    // vasyaRhezo.print();
    int queries = in.nextInt();
    while (queries-- > 0) {
      int l = in.nextInt();
      int r = in.nextInt();
      System.out.println(vasyaRhezo.query(l, r));
    }
    in.close();
  }
}
