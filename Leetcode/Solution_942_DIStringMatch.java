package Leetcode;

class Solution_942_DIStringMatch {
  public int[] diStringMatch(String S) {

    int n = S.length();
    int[] arr = new int[n + 1];
    int leftRunner = 0, rightRunner = n;
    int i = 0;
    while (i < n) {
      if (S.charAt(i) == 'I')
        arr[i++] = leftRunner++;
      else
        arr[i++] = rightRunner--;
    }
    arr[i++] = leftRunner++;
    return arr;
  }
}
