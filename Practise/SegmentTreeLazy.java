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
    //@TODO: Complete it.
  }

  public void printTree() {
    System.out.println(Arrays.toString(this.tree));
    System.out.println(Arrays.toString(this.lazy));
  }

  public static void main(String[] args) {
    int[] arr = {1,5,2,4,3};
    SegmentTreeLazy tree = new SegmentTreeLazy(arr);
    tree.printTree();
  }
}
