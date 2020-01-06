class Solution_1191_KConcatSum {
  public int kConcatenationMaxSum(int[] arr, int k) {
    long sum = 0;
    for (int item : arr)
      sum += item;
    long subMax = 0;
    long curSum = 0;
    for (int i = 0; i < arr.length * 2; i++) {
      int index = i % arr.length;
      if (curSum + arr[index] <= 0) {
        curSum = 0;
      } else {
        curSum = Math.max(curSum + arr[index], arr[index]);
        subMax = Math.max(subMax, curSum);
      }
    }
    if (k == 1 && sum == subMax)
      return (int) (sum % (long) (Math.pow(10, 9) + 7));
    if (sum > 0) {
      return (int) (((k - 2) * sum + subMax) % (long) (Math.pow(10, 9) + 7));
    }
    return (int) (subMax % (long) (Math.pow(10, 9) + 7));
  }
}
