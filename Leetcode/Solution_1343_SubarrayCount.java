class Solution {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int res = 0;
    int sum = 0;
    for (int i = -k, j = 0; j < arr.length; ++i, ++j) {
      sum += arr[j];
      if (i >= 0) {
        sum -= arr[i];
      }
      if (j >= k - 1 && sum >= k * threshold) {
        ++res;
      }
    }
    return res;
  }
}
