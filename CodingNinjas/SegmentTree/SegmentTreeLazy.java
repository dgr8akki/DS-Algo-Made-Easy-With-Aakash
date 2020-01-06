package CodingNinjas.SegmentTree;

import java.util.Arrays;

/**
 * SegmentTreeLazy
 */
public class SegmentTreeLazy {
  int[] arr;
  private int[] tree;
  private int[] lazy;

  SegmentTreeLazy(int[] arr) {
    this.arr = arr;
    this.tree = new int[4 * this.arr.length];
    this.lazy = new int[4 * this.arr.length];
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

  public void update(int leftIndex, int rightIndex, int incrementBy) {
    update(0, this.arr.length - 1, 1, leftIndex, rightIndex, incrementBy);
  }

  private void update(int start, int end, int treeNode, int leftIndex, int rightIndex, int inc) {
    if(start > end || treeNode >= this.tree.length) return;
    if(lazy[treeNode] != 0) {
      tree[treeNode] += lazy[treeNode];
      if(start != end) {
        lazy[2 * treeNode] += lazy[treeNode];
        lazy[(2 * treeNode) + 1] += lazy[treeNode];
      }
      lazy[treeNode] = 0;
    }

    if(leftIndex > end || rightIndex < start) return;
    if(leftIndex <= start && end <= rightIndex) {
      tree[treeNode] += inc;
      if(start != end) {
        lazy[2 * treeNode] += inc;
        lazy[(2 * treeNode) + 1] += inc;
      }
      return;
    }
    int mid = (start + end) / 2;
    update(start, mid, 2 * treeNode, leftIndex, rightIndex, inc);
    update(mid + 1, end, (2 * treeNode) + 1, leftIndex, rightIndex, inc);
    tree[treeNode] = Math.min(tree[2 * treeNode], tree[(2 * treeNode) + 1]);
  }

  public int query(int startingIndex, int endIndex) {
    return query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1);
  }

  private int query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    if(lazy[treeNode] != 0) {
      tree[treeNode] += lazy[treeNode];
      if(start != end) {
        lazy[2 * treeNode] += lazy[treeNode];
        lazy[(2 * treeNode) + 1] += lazy[treeNode];
      }
      lazy[treeNode] = 0;
    }
    //Fully outside
    if(startingIndex > end || endIndex < start) return Integer.MAX_VALUE;
    //Fully overlap
    if(startingIndex <= start && endIndex >= end) return tree[treeNode];
    //Partially overlap
    int mid = (start + end) / 2;
    return Math.min(query(start, mid, 2 * treeNode, startingIndex, endIndex),
      query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex));
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
    System.out.println(Arrays.toString(this.lazy));
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    SegmentTreeLazy segTree = new SegmentTreeLazy(arr);
    segTree.update(1, 1, 2);
    System.out.println(segTree.query(2,4));
    segTree.print();
  }
}
