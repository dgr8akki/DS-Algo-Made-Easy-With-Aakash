package Leetcode;

class Solution_658_KClosestElements {
  public List<Integer> findClosestElements(int[] A, int k, int x) {
    int left = 0, right = A.length - k;
    while (left < right) {
      int mid = (left + right) / 2;
      if (x - A[mid] > A[mid + k] - x)
        left = mid + 1;
      else
        right = mid;
    }
    return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
  }
}
