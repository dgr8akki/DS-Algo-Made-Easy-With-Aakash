package Practise;

import java.util.Arrays;

/**
 * SegmentTreeLazy
 */
public class SegmentTreeLazy {
  int[] arr;
  int[] tree;
  int[] lazy;
  int arrSize;

  SegmentTreeLazy(int[] arr) {
    this.arr = arr;
    this.arrSize = this.arr.length;
    this.tree = new int[3 * arrSize];
    this.lazy = new int[3 * arrSize];
    buildTree(0, arrSize - 1, 1);
  }

  private void buildTree(int givenArrayStartIdx, int givenArrayEndIdx, int treeNode) {
    if(givenArrayEndIdx == givenArrayStartIdx) {
      tree[treeNode] = arr[givenArrayEndIdx];
      return;
    }

    int mid = (givenArrayStartIdx + givenArrayEndIdx) / 2;

    buildTree(givenArrayStartIdx, mid, 2 * treeNode);
    buildTree(mid + 1, givenArrayEndIdx, (2 * treeNode) + 1);
    tree[treeNode] = Math.min(tree[2 * treeNode], tree[(2 * treeNode) + 1]);
  }

  public void update(int leftIndex, int rightIndex, int incrementedBy) {
    update(0, arrSize - 1, 1 ,leftIndex, rightIndex, incrementedBy);
  }

  private void update(int currentNodeStartIdx, int currentNodeEndIdx, int treeNode, int leftIndex, int rightIndex, int incrementedBy) {
    //Base Case
    if(currentNodeStartIdx > currentNodeEndIdx) return;

    //Update value before use
    if(lazy[treeNode] != 0) {
      tree[treeNode] += lazy[treeNode];

      if(currentNodeEndIdx != currentNodeStartIdx) {
        lazy[2 * treeNode] += lazy[treeNode];
        lazy[(2 * treeNode) + 1] += lazy[treeNode];
      }
      lazy[treeNode] = 0;
    }

    // Completely outside.
    if(rightIndex < currentNodeStartIdx || leftIndex > currentNodeEndIdx) return;

    // Completely Inside
    if(rightIndex >= currentNodeEndIdx && leftIndex <= currentNodeStartIdx) {
        tree[treeNode] += incrementedBy;

        if(currentNodeEndIdx != currentNodeStartIdx) {
          lazy[2 * treeNode] += incrementedBy;
          lazy[(2 * treeNode) + 1] += incrementedBy;
        }
        return;
    }

    // Paritally Inside

    int mid = (currentNodeStartIdx + currentNodeEndIdx) / 2;

    update(currentNodeStartIdx, mid, 2 * treeNode ,leftIndex, rightIndex, incrementedBy);
    update(mid + 1, currentNodeEndIdx, (2 * treeNode) + 1 ,leftIndex, rightIndex, incrementedBy);
    tree[treeNode] = Math.min(tree[2 * treeNode], tree[(2 * treeNode) + 1]);
  }

  public int query(int startingIndex, int endIndex) {
    return query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1);
  }

  private int query(int currentNodeStartIdx, int currentNodeEndIdx, int treeNode, int startingIndex, int endIndex) {
    if(lazy[treeNode] != 0) {
      tree[treeNode] += lazy[treeNode];
      if(currentNodeStartIdx != currentNodeEndIdx) {
        lazy[2 * treeNode] += lazy[treeNode];
        lazy[(2 * treeNode) + 1] += lazy[treeNode];
      }
      lazy[treeNode] = 0;
    }
    //Fully outside
    if(startingIndex > currentNodeEndIdx || endIndex < currentNodeStartIdx) return Integer.MAX_VALUE;
    //Fully overlap
    if(startingIndex <= currentNodeStartIdx && endIndex >= currentNodeEndIdx) return tree[treeNode];
    //Partially overlap
    int mid = (currentNodeStartIdx + currentNodeEndIdx) / 2;
    return Math.min(query(currentNodeStartIdx, mid, 2 * treeNode, startingIndex, endIndex),
      query(mid + 1, currentNodeEndIdx, (2 * treeNode) + 1, startingIndex, endIndex));
  }

  public void printTree() {
    System.out.println(Arrays.toString(this.tree));
    System.out.println(Arrays.toString(this.lazy));
  }

  public static void main(String[] args) {
    int[] arr = {1,5,2,4,3};
    SegmentTreeLazy tree = new SegmentTreeLazy(arr);
    tree.update(1, 2, 3);
    tree.update(1, 1, 2);
    System.out.println(tree.query(2,4));
    tree.printTree();
  }
}
