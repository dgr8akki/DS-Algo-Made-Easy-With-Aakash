import java.util.Scanner;

/**
 * SumOfSquares
 */
public class SumOfSquares {
  static class LazyNode {
    int type = -1;
    int value;
  }

  static class Node {
    int sum;
    int squareSum;

    public Node(int sum, int squareSum) {
      this.squareSum = squareSum;
      this.sum = sum;
    }

    public Node() {
      this.squareSum = 0;
      this.sum = 0;
    }
  }

  int[] arr;
  Node[] tree;
  LazyNode[] lazy;
  int arrSize;

  public SumOfSquares(int[] arr) {
    this.arr = arr;
    this.arrSize = this.arr.length;
    this.tree = new Node[3 * arrSize];
    this.lazy = new LazyNode[3 * arrSize];
    buildTree(0, arrSize - 1, 1);
  }

  private void buildTree(int givenArrayStartIdx, int givenArrayEndIdx, int treeNode) {
    if(givenArrayStartIdx > givenArrayEndIdx) return;
    if (givenArrayEndIdx == givenArrayStartIdx) {
      tree[treeNode] = new Node();
      tree[treeNode].sum = arr[givenArrayEndIdx];
      tree[treeNode].squareSum = arr[givenArrayEndIdx] * arr[givenArrayEndIdx];
      return;
    }

    int mid = (givenArrayStartIdx + givenArrayEndIdx) / 2;

    buildTree(givenArrayStartIdx, mid, 2 * treeNode);
    buildTree(mid + 1, givenArrayEndIdx, (2 * treeNode) + 1);
    tree[treeNode] = new Node();
    tree[treeNode].squareSum = tree[2 * treeNode].squareSum + tree[(2 * treeNode) + 1].squareSum;
    tree[treeNode].sum = tree[2 * treeNode].sum + tree[(2 * treeNode) + 1].sum;
  }

  public int query(int startingIndex, int endIndex) {
    return query(0, this.arr.length - 1, 1, startingIndex - 1, endIndex - 1).squareSum;
  }

  private Node query(int currentNodeStartIdx, int currentNodeEndIdx, int treeNode, int startingIndex, int endIndex) {
    // Update value before use
    if (lazy[treeNode] != null && lazy[treeNode].type != -1) {
      if (lazy[treeNode].type == 1) {
        // Update by incriment
        tree[treeNode].squareSum += ((lazy[treeNode].value * lazy[treeNode].value) * (currentNodeEndIdx - currentNodeEndIdx + 1)
                                    + (2 * lazy[treeNode].value * tree[treeNode].sum));
        tree[treeNode].sum += (lazy[treeNode].value * (currentNodeEndIdx - currentNodeEndIdx + 1));
      } else if (lazy[treeNode].type == 0) {
        // Update by value.
        tree[treeNode].squareSum += (lazy[treeNode].value * lazy[treeNode].value
            * (currentNodeEndIdx - currentNodeEndIdx + 1));
        tree[treeNode].sum += (lazy[treeNode].value * (currentNodeEndIdx - currentNodeEndIdx + 1));
      }

      if (currentNodeEndIdx != currentNodeStartIdx) {
        lazy[2 * treeNode] = new LazyNode();
        lazy[(2 * treeNode) + 1] = new LazyNode();
        lazy[2 * treeNode].type = lazy[treeNode].type;
        lazy[2 * treeNode].value = lazy[treeNode].value;
        lazy[(2 * treeNode) + 1].type = lazy[treeNode].type;
        lazy[(2 * treeNode) + 1].value = lazy[treeNode].value;
      }
      lazy[treeNode] = null;
    }
    // Fully outside
    if (currentNodeStartIdx > currentNodeEndIdx || startingIndex > currentNodeEndIdx || endIndex < currentNodeStartIdx)
      return new Node(0, 0);
    // Fully overlap
    if (startingIndex <= currentNodeStartIdx && endIndex >= currentNodeEndIdx)
      return tree[treeNode];
    // Partially overlap
    int mid = (currentNodeStartIdx + currentNodeEndIdx) / 2;
    Node left = query(currentNodeStartIdx, mid, 2 * treeNode, startingIndex, endIndex);
    Node right = query(mid + 1, currentNodeEndIdx, (2 * treeNode) + 1, startingIndex, endIndex);
    Node ans = new Node();
    ans.squareSum = left.squareSum + right.squareSum;
    ans.sum = left.sum + right.sum;
    return ans;
  }

  public void updateByReplacement(int startingIndex, int endIndex, int r) {
    update(0, arrSize - 1, 1, startingIndex - 1, endIndex - 1, r, 0);
  }

  public void updateByIncrement(int startingIndex, int endIndex, int incrementedBy) {
    update(0, arrSize - 1, 1, startingIndex - 1, endIndex - 1, incrementedBy, 1);
  }

  private void update(int currentNodeStartIdx, int currentNodeEndIdx, int treeNode, int leftIndex, int rightIndex,
      int value, int type) {
    // Base Case
    if (currentNodeStartIdx > currentNodeEndIdx || rightIndex < currentNodeStartIdx || leftIndex > currentNodeEndIdx)
      return;

    // Update value before use
    if (lazy[treeNode] != null && lazy[treeNode].type != -1) {
      if (lazy[treeNode].type == 1) {
        // Update by incriment
        tree[treeNode].squareSum += (lazy[treeNode].value * lazy[treeNode].value * (currentNodeEndIdx - currentNodeEndIdx + 1));
        tree[treeNode].squareSum += (2 * lazy[treeNode].value * tree[treeNode].sum);
        tree[treeNode].sum += (lazy[treeNode].value * (currentNodeEndIdx - currentNodeEndIdx + 1));
      } else if (lazy[treeNode].type == 0) {
        // Update by value.
        tree[treeNode].squareSum += (lazy[treeNode].value * lazy[treeNode].value
            * (currentNodeEndIdx - currentNodeEndIdx + 1));
        tree[treeNode].sum += (lazy[treeNode].value * (currentNodeEndIdx - currentNodeEndIdx + 1));
      }

      if (currentNodeEndIdx != currentNodeStartIdx) {
        lazy[2 * treeNode] = new LazyNode();
        lazy[(2 * treeNode) + 1] = new LazyNode();
        lazy[2 * treeNode].type = lazy[treeNode].type;
        lazy[2 * treeNode].value = lazy[treeNode].value;
        lazy[(2 * treeNode) + 1].type = lazy[treeNode].type;
        lazy[(2 * treeNode) + 1].value = lazy[treeNode].value;
      }
      lazy[treeNode] = null;
    }

    // Completely outside.
    if (currentNodeStartIdx > currentNodeEndIdx || rightIndex < currentNodeStartIdx || leftIndex > currentNodeEndIdx)
      return;

    // Completely Inside
    if (rightIndex >= currentNodeEndIdx && leftIndex <= currentNodeStartIdx) {
      tree[treeNode] = new Node();
      if (type == 1) {
        // Update by incriment
        tree[treeNode].squareSum += (value * value) * (currentNodeEndIdx - currentNodeEndIdx + 1);
        tree[treeNode].squareSum += (2 * tree[treeNode].sum * value);
        tree[treeNode].sum += (value * (currentNodeEndIdx - currentNodeEndIdx + 1));
      } else if (type == 0) {
        // Update by value.
        tree[treeNode].squareSum += (value * value * (currentNodeEndIdx - currentNodeEndIdx + 1));
        tree[treeNode].sum += (value * (currentNodeEndIdx - currentNodeEndIdx + 1));
      }
      return;
    }

    // Paritally Inside

    int mid = (currentNodeStartIdx + currentNodeEndIdx) / 2;

    update(currentNodeStartIdx, mid, 2 * treeNode, leftIndex, rightIndex, value, type);
    update(mid + 1, currentNodeEndIdx, (2 * treeNode) + 1, leftIndex, rightIndex, value, type);
    tree[treeNode].squareSum = tree[2 * treeNode].squareSum + tree[(2 * treeNode) + 1].squareSum;
    tree[treeNode].sum = tree[2 * treeNode].sum + tree[(2 * treeNode) + 1].sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int testCaseId = 1; testCaseId <= t; testCaseId++) {
      System.out.println("Case " + testCaseId + ":");
      int n = in.nextInt();
      int q = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = in.nextInt();
      SumOfSquares tree = new SumOfSquares(arr);
      for (int i = 0; i < q; i++) {
        int type = in.nextInt();
        int startingIndex = in.nextInt();
        int endIndex = in.nextInt();
        switch (type) {
        case 2:
          System.out.println(tree.query(startingIndex, endIndex));
          break;
        case 1:
          int x = in.nextInt();
          tree.updateByIncrement(startingIndex, endIndex, x);
          break;
        case 0:
          int r = in.nextInt();
          tree.updateByReplacement(startingIndex, endIndex, r);
          break;
        }
      }
    }
    in.close();
  }
}
