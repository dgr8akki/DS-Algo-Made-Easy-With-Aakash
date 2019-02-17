import java.util.Scanner;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * MaximumPairSum
 */
public class MaximumPairSum {
  static class Node {
    int max = Integer.MIN_VALUE;
    int secMax = Integer.MIN_VALUE;;

    @Override
    public String toString() {
      return this.max + ", " + this.secMax;
    }
  }

  int[] arr;
  private Node[] tree;

  MaximumPairSum(int[] arr) {
    this.arr = arr;
    this.tree = new Node[3 * this.arr.length];
    for(int i = 0; i < this.tree.length; i++)
      this.tree[i] = new Node();
    this.buildTree(0, arr.length - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if(start == end) {
      tree[treeNode].max = arr[start];
      tree[treeNode].secMax = Integer.MIN_VALUE;
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    Node left = tree[2 * treeNode];
    Node right = tree[(2 * treeNode) + 1];
    tree[treeNode].max = Math.max(left.max, right.max);
    tree[treeNode].secMax = Math.min(
      Math.max(left.max, right.secMax),
      Math.max(right.max, left.secMax)
    );
    return;
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
  }

  public void update(int index, int newValue) {
    update(0, this.arr.length - 1, 1, index - 1, newValue);
  }

  private void update(int start, int end, int treeNode, int index, int newValue) {
    if(start == end  && start == index) {
      tree[treeNode].max = newValue;
      tree[treeNode].secMax = Integer.MIN_VALUE;
      return;
    }
    int mid = (start + end) / 2;
    if(index > mid)
      update(mid + 1, end, (2 * treeNode) + 1, index, newValue);
    else
      update(start, mid, 2 * treeNode, index, newValue);
    Node left = tree[2 * treeNode];
    Node right = tree[(2 * treeNode) + 1];
    tree[treeNode].max = Math.max(left.max, right.max);
    tree[treeNode].secMax = Math.min(
      Math.max(left.max, right.secMax),
      Math.max(right.max, left.secMax)
    );
    return;
  }

  public int query(int startingIndex, int endIndex) {
    Node ans = query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1);
    return ans.secMax + ans.max;
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
    ans.max = Math.max(left.max, right.max);
    ans.secMax = Math.min(
      Math.max(left.max, right.secMax),
      Math.max(right.max, left.secMax)
    );
    return ans;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    MaximumPairSum segTree = new MaximumPairSum(arr);
    int q = in.nextInt();
    while(q-- > 0) {
      char type = in.next().charAt(0);
      int l = in.nextInt();
      int r = in.nextInt();
      if(type == 'Q')
        System.out.println(segTree.query(l,r));
      else if(type == 'U')
        segTree.update(l, r);
    }
    in.close();
  }
}