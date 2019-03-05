import java.util.Arrays;
import java.util.Scanner;

/**
 * TwoVsThree
 */
public class TwoVsThree {

  String input;
  int[] cache;
  private int[] tree;
  int[] pow;

  TwoVsThree(String s) {
    this.input = s;
    this.cache = new int[this.input.length()];
    this.tree = new int[4 * this.input.length()];
    this.pow = new int[this.input.length() + 1];
    pow[0] = 1;
    for(int i = 1; i <= this.input.length(); ++i)
        pow[i] = (pow[i-1]*2)%3;
    this.buildTree(0, this.input.length() - 1, 1);
  }

  private void buildTree(int start, int end, int treeNode) {
    if (start == end) {
      tree[treeNode] = input.charAt(start) == '0' ? 0 : 1;
      return;
    }
    int mid = (start + end) / 2;
    buildTree(start, mid, 2 * treeNode);
    buildTree(mid + 1, end, (2 * treeNode) + 1);
    tree[treeNode] = ((tree[2 * treeNode] * pow[end - mid]) + tree[(2 * treeNode) + 1]) % 3;
  }

  public void print() {
    System.out.println(Arrays.toString(this.tree));
  }

  public void update(int index) {
    update(0, this.input.length() - 1, 1, index);
  }

  public int query(int startingIndex, int endIndex) {
    return query(0, this.input.length() - 1, 1, startingIndex, endIndex);
  }

  private int query(int start, int end, int treeNode, int startingIndex, int endIndex) {
    // Fully outside
    if (start > end || startingIndex > end || endIndex < start)
      return 0;
    // Fully overlap
    if (startingIndex <= start && endIndex >= end)
      return (pow[endIndex - end] * tree[treeNode]) % 3;
    // Partially overlap
    int mid = (start + end) / 2;
    int left = query(start, mid, 2 * treeNode, startingIndex, endIndex);
    int right = query(mid + 1, end, (2 * treeNode) + 1, startingIndex, endIndex);
    return (left + right) % 3;
  }

  public void update(int start, int end, int treeNode, int index) {
    if (start == end && start == index) {
      if (input.charAt(index) == '1' || cache[index] == 1)
        return;
      tree[treeNode] = 1;
      cache[index] = 1;
      return;
    }
    int mid = (start + end) / 2;
    if (index > mid)
      update(mid + 1, end, (2 * treeNode) + 1, index);
    else
      update(start, mid, 2 * treeNode, index);
    tree[treeNode] = ((tree[2 * treeNode] * pow[end - mid]) + tree[(2 * treeNode) + 1]) % 3;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextInt();
    String input = in.next();
    TwoVsThree segTree = new TwoVsThree(input);
    int q = in.nextInt();
    while (q-- > 0) {
      int type = in.nextInt();
      switch (type) {
      case 0:
        int l = in.nextInt();
        int r = in.nextInt();
        System.out.println(segTree.query(l, r));
        break;
      case 1:
        segTree.update(in.nextInt());
        break;
      }
    }
    in.close();
  }
}
