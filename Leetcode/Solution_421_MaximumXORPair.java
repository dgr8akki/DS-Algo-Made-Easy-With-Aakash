package Leetcode;

class Solution_421_MaximumXORPair {
  public int findMaximumXOR(int[] nums) {
    BitNode root = new BitNode();
    for (int num : nums)
      buildBitTrie(root, num);
    return findMaxXOR(root.zero, root.zero);
  }

  private int findMaxXOR(BitNode a, BitNode b) {
    if (a == null || b == null)
      return 0;
    if (a.value != -1 && b.value != -1)
      return a.value ^ b.value;

    int max = Math.max(findMaxXOR(a.zero, b.one), findMaxXOR(a.one, b.zero));
    if (max == 0)
      max = Math.max(findMaxXOR(a.zero, b.zero), findMaxXOR(a.one, b.one));
    return max;
  }

  private void buildBitTrie(BitNode root, int num) {
    int[] bits = new int[32];
    for (int i = 0, j = num; i <= 31; i++, j >>= 1) {
      bits[i] = (j & 1);
    }

    for (int i = 31; i >= 0; i--) {
      if (bits[i] == 0) {
        if (root.zero == null)
          root.zero = new BitNode();
        root = root.zero;
      } else {
        if (root.one == null)
          root.one = new BitNode();
        root = root.one;
      }
    }
    root.value = num;
  }

  private class BitNode {
    public int value;
    public BitNode zero;
    public BitNode one;

    public BitNode() {
      value = -1;
      zero = one = null;
    }
  }
}
