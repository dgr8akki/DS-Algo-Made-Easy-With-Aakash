package Leetcode;

class Solution_1228_MissingInAP {
  public int missingNumber(int[] arr) {
    int a = arr[0], n = arr.length + 1, an = arr[arr.length - 1];
    double sum = n * (a + an) / 2;
    for (int el : arr) {
      sum -= el;
    }
    return (int) sum;
  }
}
