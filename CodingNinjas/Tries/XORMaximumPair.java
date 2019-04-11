/**
 * XORMaximumPair
 */
public class XORMaximumPair {
  public static class TrieNode {
    TrieNode left, right;
    int value = 0;
  }

  private static TrieNode root;
  private static int[] arr;

  XORMaximumPair(int[] arr) {
    this.arr = arr;
    this.root = new TrieNode();
    for (int el : arr)
      insert(el);
  }

  public static void insert(int val) {
    TrieNode current = root;
    for (int i = 31; i >= 0; i--) {
      int bit = (val & (1 << i)) >= 1 ? 1 : 0;
      if (bit == 0) {
        if (current.left == null)
          current.left = new TrieNode();
        current = current.left;
      } else {
        if (current.right == null)
          current.right = new TrieNode();
        current = current.right;
      }
    }
  }

  public static int getXORMaxPairValue() {
    int maxXOR = Integer.MIN_VALUE;
    for (int val : arr) {
      TrieNode current = root;
      int currentXOR = 0;

      for (int i = 31; i >= 0; i--) {
        int bit = (val << i) & 1;
        if (bit == 0) {
          if (current.right != null) {
            currentXOR += (1 << i);
            current = current.right;
          } else
            current = current.left;
        } else {
          if (current.left != null) {
            currentXOR += (1 << i);
            current = current.left;
          } else
            current = current.right;
        }
      }

      maxXOR = Math.max(maxXOR, currentXOR);
    }
    return maxXOR;
  }

  public static void main(String[] args) {
    int[] arr = { 8, 1, 2, 15, 10, 5 };
    XORMaximumPair pair = new XORMaximumPair(arr);
    System.out.println(pair.getXORMaxPairValue());
  }
}
