import java.util.*;

public class SegmentTreeLazy {
  public int[] createTree(int[] arr) {
    int segTreeSize = (2 * NextPowerOfTwo.nextPowerOf2(arr.length)) - 1;
    int[] segTree = new int[segTreeSize];

    for (int i = 0; i < segTree.length; i++)
      segTree[i] = Integer.MAX_VALUE;

    constructMinSegmentTree(segTree, arr, 0, arr.length - 1, 0);
    return segTree;
  }

  private void constructMinSegmentTree(int[] segTree, int[] arr, int start, int end, int currentIndex) {
    if (start == end) {
      segTree[currentIndex] = arr[start];
      return;
    }

    int mid = (start + end) / 2;
    constructMinSegmentTree(segTree, arr, start, mid, (2 * currentIndex) + 1);
    constructMinSegmentTree(segTree, arr, mid + 1, end, (2 * currentIndex) + 2);
    segTree[currentIndex] = Math.min(segTree[(2 * currentIndex) + 1], segTree[(2 * currentIndex) + 2]);
  }

  public void updateTreeRangeLazy(int[] arr, int[] segTree, int[] lazy, int startRange, int endRange, int del) {
    updateTreeRangeLazy(segTree, lazy, startRange, endRange, del, 0, arr.length - 1, 0);
  }

  private void updateTreeRangeLazy(int[] segArr, int[] lazy, int startingIndex, int endIndex, int del, int start, int end, int currentIndex) {
    if(start > end) return;

    if(lazy[currentIndex] != 0) {
      segArr[currentIndex] += lazy[currentIndex];

      if(start != end) {
        lazy[(2 * currentIndex) + 1] += lazy[currentIndex];
        lazy[(2 * currentIndex) + 2] += lazy[currentIndex];
      }

      lazy[currentIndex] = 0;
    }

    if(endIndex < start || startingIndex > end) return;

    if(startingIndex <= start && endIndex >= end) {
      segArr[currentIndex] += del;

      if(start != end) {
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

  public void printTree(int[] segTree) {
    System.out.println(Arrays.toString(segTree));
  }

  public int rmq(int[] segTree, int startingIndex, int endingIndex, int len) {
    return 0;
  }

  public static void main(String args[]) {
    int[] arr = { 0, 3, -4, 2, 1, 6, -1 };
    SegmentTreeLazy segmentTree = new SegmentTreeLazy();
    int[] segArr = segmentTree.createTree(arr);
    segmentTree.printTree(segArr);
  }
}
