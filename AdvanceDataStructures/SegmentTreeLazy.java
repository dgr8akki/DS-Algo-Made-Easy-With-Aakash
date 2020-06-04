package AdvanceDataStructures;

import java.util.Arrays;

public class SegmentTreeLazy {
  public static void main(String[] args) {
    int[] arr = { -1, 2, 4, 1, 7, 1, 3, 2 };
    SegmentTreeLazy segmentTree = new SegmentTreeLazy();
    int[] segArr = segmentTree.createTree(arr);
    int[] lazy = new int[segArr.length];

    segmentTree.updateTreeRangeLazy(arr, segArr, lazy, 0, 3, 1);
    segmentTree.updateTreeRangeLazy(arr, segArr, lazy, 0, 0, 2);
    System.out.println(segmentTree.rmqLazy(segArr, lazy, 3, 5, arr.length));
    SegmentTreeLazy.printTree(segArr);
  }

  private int[] createTree(int[] arr) {
    int segTreeSize = (2 * NextPowerOfTwo.nextPowerOf2(arr.length)) - 1;
    int[] segTree = new int[segTreeSize];

    for (int i = 0; i < segTree.length; i++) {
      segTree[i] = Integer.MAX_VALUE;
    }

    constructMinSegmentTree(segTree, arr, 0, arr.length - 1, 0);
    return segTree;
  }

  private static void constructMinSegmentTree(int[] segTree, int[] arr, int start, int end, int currentIndex) {
    if (start == end) {
      segTree[currentIndex] = arr[start];
      return;
    }

    int mid = (start + end) / 2;
    constructMinSegmentTree(segTree, arr, start, mid, (2 * currentIndex) + 1);
    constructMinSegmentTree(segTree, arr, mid + 1, end, (2 * currentIndex) + 2);
    segTree[currentIndex] = Math.min(segTree[(2 * currentIndex) + 1], segTree[(2 * currentIndex) + 2]);
  }

  private void updateTreeRangeLazy(int[] arr, int[] segTree, int[] lazy, int startRange, int endRange, int del) {
    updateTreeRangeLazy(segTree, lazy, startRange, endRange, del, 0, arr.length - 1, 0);
  }

  private static void updateTreeRangeLazy(int[] segArr, int[] lazy, int startingIndex, int endIndex, int del, int start,
      int end, int currentIndex) {
    if (start > end) {
      return;
    }

    if (lazy[currentIndex] != 0) {
      segArr[currentIndex] += lazy[currentIndex];

      if (start != end) {
        lazy[(2 * currentIndex) + 1] += lazy[currentIndex];
        lazy[(2 * currentIndex) + 2] += lazy[currentIndex];
      }

      lazy[currentIndex] = 0;
    }

    if (endIndex < start || startingIndex > end) {
      return;
    }

    if (startingIndex <= start && endIndex >= end) {
      segArr[currentIndex] += del;

      if (start != end) {
        lazy[(2 * currentIndex) + 1] += lazy[currentIndex];
        lazy[(2 * currentIndex) + 2] += lazy[currentIndex];
      }

      return;
    }

    int mid = (start + end) / 2;

    updateTreeRangeLazy(segArr, lazy, startingIndex, endIndex, del, start, mid, (2 * currentIndex) + 1);
    updateTreeRangeLazy(segArr, lazy, startingIndex, endIndex, del, mid + 1, end, (2 * currentIndex) + 2);

    segArr[currentIndex] = Math.min(segArr[(2 * currentIndex) + 1], segArr[(2 * currentIndex) + 2]);
  }

  private static void printTree(int[] segTree) {
    System.out.println(Arrays.toString(segTree));
  }

  private int rmqLazy(int[] segTree, int[] lazy, int startingIndex, int endingIndex, int len) {
    return rangeMinimumQueryLazy(segTree, lazy, startingIndex, endingIndex, 0, len - 1, 0);
  }

  private static int rangeMinimumQueryLazy(int[] segTree, int[] lazy, int startingIndex, int endingIndex, int start,
      int end, int currentIndex) {
    if (start > end) {
      return Integer.MAX_VALUE;
    }

    if (lazy[currentIndex] != 0) {
      segTree[currentIndex] += lazy[currentIndex];

      if (start != end) {
        lazy[(2 * currentIndex) + 1] += lazy[currentIndex];
        lazy[(2 * currentIndex) + 2] += lazy[currentIndex];
      }

      lazy[currentIndex] = 0;
    }

    if (endingIndex < start || startingIndex > end) {
      return Integer.MAX_VALUE;
    }

    if (startingIndex <= start && endingIndex >= end) {
      return segTree[currentIndex];
    }

    int mid = (start + end) / 2;

    return Math.min(
        rangeMinimumQueryLazy(segTree, lazy, startingIndex, endingIndex, start, mid, (2 * currentIndex) + 1),
        rangeMinimumQueryLazy(segTree, lazy, startingIndex, endingIndex, start, mid, (2 * currentIndex) + 1));
  }
}
