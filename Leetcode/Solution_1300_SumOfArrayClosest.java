class Solution {
  public int findBestValue(int[] arr, int target) {
    int left = 0;
    int right = target;

    while (left < right) {

      int mid = (left + right) / 2;

      int sum = getSum(arr, mid);
      if (sum < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    if (Math.abs(target - getSum(arr, left)) >= Math.abs(target - getSum(arr, left - 1))) {
      return left - 1;
    } else {
      return left;
    }

  }

  public int getSum(int[] arr, int value) {
    int sum = 0;
    for (int ele : arr) {
      sum += (ele > value) ? value : ele;
    }
    return sum;
  }
}
