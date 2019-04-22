class Solution {

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    int last = binarySearch(nums, target);

    if (Arrays.binarySearch(nums, target) < 0) {
      Arrays.fill(res, -1);
      return res;
    }
    res[1] = last;
    for (int i = last; i >= 0; i--) {
      if (nums[i] == target)
        res[0] = i;
    }

    return res;
  }

  public int binarySearch(int[] A, int target) {
    int start = 0, end = A.length, mid = -1;
    while (start < end) {
      mid = (start + end) / 2;
      if (target >= A[mid])
        start = mid + 1;
      else
        end = mid;
    }
    return start - 1;
  }
}
