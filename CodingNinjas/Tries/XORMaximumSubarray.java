/**
 * XORMaximumSubarray
 */
public class XORMaximumSubarray {
  public static class TrieNode {
    TrieNode left, right;
    int value = 0;
  }

  private static TrieNode root;
  private static int[] arr;

  XORMaximumSubarray(int[] arr) {
    this.arr = arr;
    this.root = new TrieNode();
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

    current.value = val;
  }

  public static int maxSubarrayXOR(int arr[], int n) {
    int maxXOR = Integer.MIN_VALUE;
    int preXOR = 0;
    for (int val : arr) {
      TrieNode current = root;
      preXOR ^= val;
      insert(preXOR);
      for (int i = 31; i >= 0; i--) {
        int bit = (val << i) & 1;
        if (bit == 0) {
          if (current.right != null) {
            current = current.right;
          } else
            current = current.left;
        } else {
          if (current.left != null) {
            current = current.left;
          } else
            current = current.right;
        }
      }

      maxXOR = Math.max(maxXOR, preXOR ^ current.value);
    }
    return maxXOR;
  }

  public static void main(String[] args) {
    int arr[] = { 8, 1, 2, 12 };
    int n = arr.length;
    XORMaximumSubarray pair = new XORMaximumSubarray(arr);
    System.out.println("Max subarray XOR is " + pair.maxSubarrayXOR(arr, n));
  }
}
