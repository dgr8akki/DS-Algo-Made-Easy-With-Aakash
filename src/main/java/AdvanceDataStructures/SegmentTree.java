package AdvanceDataStructures;

import java.util.Arrays;

public class SegmentTree {
  public static void main(String[] args) {
    int[] arr = {0, 3, -4, 2, 1, 6, -1};
    SegmentTree segmentTree = new SegmentTree();
    int[] segArr = SegmentTree.createTree(arr);
    System.out.println(SegmentTree.rmq(segArr, 0, 3, arr.length));
  }

  private static void constructMinSegmentTree(
    int[] segTree, int[] arr, int start, int end, int currentIndex) {
    if (start == end) {
      segTree[currentIndex] = arr[start];
      return;
    }

    int mid = (start + end) / 2;
    constructMinSegmentTree(segTree, arr, start, mid, (2 * currentIndex) + 1);
    constructMinSegmentTree(segTree, arr, mid + 1, end, (2 * currentIndex) + 2);
    segTree[currentIndex] =
        Math.min(segTree[(2 * currentIndex) + 1], segTree[(2 * currentIndex) + 2]);
  }

  private static void updateSegmentTree(
    int[] segArr, int indexToBeUpdate, int del, int start, int end, int currentIndex) {
    if (indexToBeUpdate > end || indexToBeUpdate < start) {
      return;
    }
    if (start == end) {
      segArr[currentIndex] += del;
      return;
    }
    int mid = (start + end) / 2;
    updateSegmentTree(segArr, indexToBeUpdate, del, start, mid, (2 * currentIndex) + 1);
    updateSegmentTree(segArr, indexToBeUpdate, del, mid + 1, end, (2 * currentIndex) + 2);
    segArr[currentIndex] = Math.min(segArr[(2 * currentIndex) + 1], segArr[(2 * currentIndex) + 2]);
  }

  public static void printTree(int[] segTree) {
    System.out.println(Arrays.toString(segTree));
  }

  private static int rangeMinimumQuery(
    int[] segmentTree, int low, int high, int startingIndex, int endingIndex, int currentIndex) {
    if (startingIndex <= low && endingIndex >= high) {
      return segmentTree[currentIndex];
    }
    if (startingIndex > high || endingIndex < low) {
      return Integer.MAX_VALUE;
    }
    int mid = (low + high) / 2;
    return Math.min(
        rangeMinimumQuery(segmentTree, low, mid, startingIndex, endingIndex, 2 * currentIndex + 1),
        rangeMinimumQuery(
            segmentTree, mid + 1, high, startingIndex, endingIndex, 2 * currentIndex + 2));
  }

  private static int[] createTree(int[] arr) {
    int segTreeSize = (2 * NextPowerOfTwo.nextPowerOf2(arr.length)) - 1;
    int[] segTree = new int[segTreeSize];

    Arrays.fill(segTree, Integer.MAX_VALUE);

    constructMinSegmentTree(segTree, arr, 0, arr.length - 1, 0);
    return segTree;
  }

  public static void updateTree(int[] arr, int[] segTree, int index, int del) {
    arr[index] += del;
    updateSegmentTree(segTree, index, del, 0, arr.length - 1, 0);
  }

  private static int rmq(int[] segTree, int startingIndex, int endingIndex, int len) {
    return rangeMinimumQuery(segTree, 0, len - 1, startingIndex, endingIndex, 0);
  }
}
