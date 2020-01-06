package CodingNinjas.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;
/**
 * RangeMinimumQuery
 */
public class RangeMinimumQuery {
  int[] arr;
  private int[] tree;

  RangeMinimumQuery(int[] arr) {
    this.arr = arr;
    this.tree = new int[4 * this.arr.length];
    for(int i = 0; i < this.tree.length; i++)
      this.tree[i] = Integer.MAX_VALUE;
    this.buildTree(0, arr.length - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if(start == end) {
      tree[treeNode] = arr[start];
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    tree[treeNode] = Math.min(tree[2 * treeNode], tree[(2 * treeNode) + 1]);
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
  }

  public void update(int index, int newValue) {
    update(0, this.arr.length - 1, 1, index - 1, newValue);
  }

  public int query(int startingIndex, int endIndex) {
    return query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1);
  }

  private int query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    //Fully outside
    if(startingIndex > end || endIndex < start) return Integer.MAX_VALUE;
    //Fully overlap
    if(startingIndex <= start && endIndex >= end) return tree[treeNode];
    //Partially overlap
    int mid = (start + end) / 2;
    return Math.min(query(start, mid, 2 * treeNode, startingIndex, endIndex),
      query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex));
  }

  public void update(int start, int end, int treeNode, int index, int newValue) {
    if(start == end  && start == index) {
      arr[index] = newValue;
      tree[treeNode] = newValue;
      return;
    }
    int mid = (start + end) / 2;
    if(index > mid)
      update(mid + 1, end, (2 * treeNode) + 1, index, newValue);
    else
      update(start, mid, 2 * treeNode, index, newValue);
    tree[treeNode] = Math.min(tree[2 * treeNode], tree[(2 * treeNode) + 1]);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    RangeMinimumQuery segTree = new RangeMinimumQuery(arr);
    segTree.print();
    while(q-- > 0) {
      char type = in.next().charAt(0);
      int l = in.nextInt();
      int r = in.nextInt();
      if(type == 'q')
        System.out.println(segTree.query(l,r));
      else if(type == 'u')
        segTree.update(l, r);
    }
    in.close();
  }
}