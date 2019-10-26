package Leetcode;

class Solution {
  public List<Integer> addToArrayForm(int[] digits, int k) {

    int n = digits.length;
    List<Integer> res = new ArrayList<>(n + 1);
    List<Integer> K = new ArrayList<>();
    while (k > 0) {
      K.add(k % 10);
      k /= 10;
    }
    Collections.reverse(K);

    int j = K.size() - 1;
    int carry = 0;
    for (int i = n - 1; i >= 0; i--) {
      int otherVal = j >= 0 ? K.get(j) : 0;
      j--;
      int val = digits[i] + carry + otherVal;
      res.add(val % 10);
      carry = val / 10;
    }

    while (j >= 0) {
      int val = carry + K.get(j--);
      res.add(val % 10);
      carry = val / 10;
    }
    if (carry > 0)
      res.add(carry);
    Collections.reverse(res);
    return res;
  }
}
