import java.util.Arrays;
import java.util.Scanner;

/**
 * CountEvenOdd
 */
public class CountEvenOdd {

  static class Node {
    int odd;
    int even;
  }

  int[] arr;
  private Node[] tree;

  CountEvenOdd(int[] arr) {
    this.arr = arr;
    this.tree = new Node[4 * this.arr.length];
    this.buildTree(0, arr.length - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if (start == end) {
      tree[treeNode] = new Node();
      if (arr[start] % 2 == 0)
        tree[treeNode].even++;
      else
        tree[treeNode].odd++;
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    tree[treeNode] = new Node();
    tree[treeNode].odd = tree[2 * treeNode].odd + tree[(2 * treeNode) + 1].odd;
    tree[treeNode].even = tree[2 * treeNode].even + tree[(2 * treeNode) + 1].even;
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
  }

  public void update(int index, int newValue) {
    update(0, this.arr.length - 1, 1, index - 1, newValue);
  }

  public int query(int startingIndex, int endIndex, int type) {
    Node ans = query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1, type);
    if (type == 2)
      return ans.odd;
    return ans.even;
  }

  private Node query(int start, int end, int treeNode, int startingIndex, int endIndex, int type) {
    // Fully outside
    if (startingIndex > end || endIndex < start)
      return new Node();
    // Fully overlap
    if (startingIndex <= start && endIndex >= end) {
      return tree[treeNode];
    }
    // Partially overlap
    int mid = (start + end) / 2;
    Node leftResult = query(start, mid, 2 * treeNode, startingIndex, endIndex, type);
    Node rightResult = query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex, type);
    Node result = new Node();
    result.even = leftResult.even + rightResult.even;
    result.odd = leftResult.odd + rightResult.odd;
    return result;
  }

  public void update(int start, int end, int treeNode, int index, int newValue) {
    if (start == end) {
      if (arr[start] % 2 == 0 && newValue % 2 != 0) {
        tree[treeNode].even--;
        tree[treeNode].odd++;
      } else if (arr[start] % 2 != 0 && newValue % 2 == 0) {
        tree[treeNode].odd--;
        tree[treeNode].even++;
      }
      arr[start] = newValue;
      return;
    }
    int mid = (start + end) / 2;
    if (index > mid)
      update(mid + 1, end, (2 * treeNode) + 1, index, newValue);
    else
      update(start, mid, 2 * treeNode, index, newValue);
    tree[treeNode] = new Node();
    tree[treeNode].odd = tree[2 * treeNode].odd + tree[(2 * treeNode) + 1].odd;
    tree[treeNode].even = tree[2 * treeNode].even + tree[(2 * treeNode) + 1].even;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    CountEvenOdd segTree = new CountEvenOdd(arr);
    // segTree.print();
    int q = in.nextInt();
    while (q-- > 0) {
      int type = in.nextInt();
      int l = in.nextInt();
      int r = in.nextInt();
      switch (type) {
      case 0:
        segTree.update(l, r);
        break;
      case 1:
        System.out.println(segTree.query(l, r, 1));
        break;
      case 2:
        System.out.println(segTree.query(l, r, 2));
        break;
      }
    }
    in.close();
  }
}
