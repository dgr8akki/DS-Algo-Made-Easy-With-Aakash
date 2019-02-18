import java.util.Scanner;

/**
 * MaximumSumSubarray
 */
public class MaximumSumSubarray {
  static class Node {
    int maxSum = 0;
    int sum = 0;
    int prefixSum = 0;
    int suffixSum = 0;
  }

  int[] arr;
  private Node[] tree;

  MaximumSumSubarray(int[] arr) {
    this.arr = arr;
    this.tree = new Node[4 * this.arr.length];
    this.buildTree(0, arr.length - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if(start == end) {
      tree[treeNode] = new Node();
      tree[treeNode].maxSum = arr[start];
      tree[treeNode].sum = arr[start];
      tree[treeNode].prefixSum = arr[start];
      tree[treeNode].suffixSum = arr[start];
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    Node left = tree[2 * treeNode];
    Node right = tree[(2 * treeNode) + 1];
    tree[treeNode] = new Node();
    tree[treeNode].sum = left.sum + right.sum;
    tree[treeNode].prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);
    tree[treeNode].suffixSum = Math.max(right.suffixSum, left.suffixSum + right.sum);
    tree[treeNode].maxSum = Math.max(
      left.maxSum,
      Math.max(
        right.maxSum,
        Math.max(
          left.sum + right.prefixSum,
          Math.max(
            right.sum + left.suffixSum,
            left.suffixSum + right.prefixSum
          )
        )
      )
    );
    return;
  }

  public int query(int startingIndex, int endIndex) {
    Node ans = query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1);
    return ans.maxSum;
  }

  private Node query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    //Fully outside
    if(startingIndex > end || endIndex < start) return new Node();
    //Fully overlap
    if(startingIndex <= start && endIndex >= end) return tree[treeNode];
    //Partially overlap
    int mid = (start + end) / 2;
    Node left = query(start, mid, 2 * treeNode, startingIndex, endIndex);
    Node right = query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex);
    Node ans = new Node();
    ans.sum = left.sum + right.sum;
    ans.prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);
    ans.suffixSum = Math.max(right.suffixSum, left.suffixSum + right.sum);
    ans.maxSum = Math.max(
      left.maxSum,
      Math.max(
        right.maxSum,
        Math.max(
          left.sum + right.prefixSum,
          Math.max(
            right.sum + left.suffixSum,
            left.suffixSum + right.prefixSum
          )
        )
      )
    );
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    MaximumSumSubarray segTree = new MaximumSumSubarray(arr);
    int q = in.nextInt();
    //segTree.print();
    while(q-- > 0) {
      int l = in.nextInt();
      int r = in.nextInt();
      System.out.println(segTree.query(l,r));
    }
    in.close();
  }
}