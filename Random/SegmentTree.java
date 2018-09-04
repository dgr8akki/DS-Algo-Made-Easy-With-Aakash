import java.util.*;

public class SegmentTree {
  public int[] createTree(int[] arr) {
    int segTreeSize = ( 2 * NextPowerOfTwo.nextPowerOf2(arr.length) ) - 1;
    int[] segTree = new int[segTreeSize];

    for(int i = 0; i < segTree.length; i++)
      segTree[i] = Integer.MAX_VALUE;

    constructMinSegmentTree(segTree, arr, 0, arr.length - 1, 0);
    return segTree;
  }

  private void constructMinSegmentTree(int[] segTree, int[] arr, int start, int end, int currentIndex) {
    if(start == end) {
      segTree[currentIndex] = arr[start];
      return ;
    }

    int mid = ( start + end ) / 2;
    constructMinSegmentTree(segTree, arr, start, mid, (2 * currentIndex) + 1);
    constructMinSegmentTree(segTree, arr, mid + 1, end, (2 * currentIndex) + 2);
    segTree[currentIndex] = Math.min(segTree[(2 * currentIndex) + 1], segTree[(2 * currentIndex) + 2]);
  }

  public void updateTree(int[] segTree, int index, int key) {

  }

  public void printTree(int[] segTree) {
    System.out.println(Arrays.toString(segTree));
  }

  public int rmq(int[] segTree, int startingIndex, int EndingIndex) {
    return 0;
  }

  public static void main(String args[]) {
    int[] arr = {1, 2, 4, 5, 8, 9};
    SegmentTree segmentTree = new SegmentTree();
    int[] segArr = segmentTree.createTree(arr);
    segmentTree.printTree(segArr);
  }
}
