package Leetcode;

class Solution_667_BeautifulArrangements {
  public int[] constructArray(int n, int k) {
    int[] result = new int[n];
    int left = 1, right = n;
    for (int i = 0; i < n; i++) {
      result[i] = k % 2 != 0 ? left++ : right--;
      if (k > 1)
        k--;
    }

    return result;
  }
}
