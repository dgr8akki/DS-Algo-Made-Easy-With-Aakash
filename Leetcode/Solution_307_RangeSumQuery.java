package Leetcode;

import java.util.Arrays;

class Solution_307_RangeSumQuery {
  private final int[] arr;
  private final int[] tree;

  public Solution_307_RangeSumQuery(int[] arr) {
    this.arr = arr;
    tree = new int[4 * this.arr.length];
    buildTree(0, arr.length - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if (end == -1) {
      return;
    }
    if (start == end) {
      tree[treeNode] = arr[start];
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    tree[treeNode] = tree[2 * treeNode] + tree[(2 * treeNode) + 1];
  }

  public void print() {
    System.out.println(Arrays.toString(tree));
  }

  public void update(int index, int newValue) {
    update(0, arr.length - 1, 1, index, newValue);
  }

  public int sumRange(int startingIndex, int endIndex) {
    return query(0, arr.length - 1, 1, startingIndex, endIndex);
  }

  private int query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    // Fully outside
    if (startingIndex > end || endIndex < start) {
      return 0;
    }
    // Fully overlap
    if (startingIndex <= start && endIndex >= end) {
      return tree[treeNode];
    }
    // Partially overlap
    int mid = (start + end) / 2;
    return query(start, mid, 2 * treeNode, startingIndex, endIndex)
        + query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex);
  }

  public void update(int start, int end, int treeNode, int index, int newValue) {
    if (start == end && start == index) {
      arr[index] = newValue;
      tree[treeNode] = newValue;
      return;
    }
    int mid = (start + end) / 2;
    if (index > mid) {
      update(mid + 1, end, (2 * treeNode) + 1, index, newValue);
    } else {
      update(start, mid, 2 * treeNode, index, newValue);
    }
    tree[treeNode] = tree[2 * treeNode] + tree[(2 * treeNode) + 1];
  }
}
