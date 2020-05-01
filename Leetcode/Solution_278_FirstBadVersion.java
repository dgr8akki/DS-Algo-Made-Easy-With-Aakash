package Leetcode;

public class Solution_278_FirstBadVersion {
  public int firstBadVersion(int n) {
    int start = 1, end = n, mid = -1;
    Map<Integer, Boolean> map = new HashMap<>();

    while (start <= end) {
      mid = start + (end - start) / 2;
      boolean isCurrentBad = isCurrentActuallyBad(mid, map);
      if (isCurrentBad) {
        if (mid > 1 && !isCurrentActuallyBad(mid - 1, map))
          return mid;
        if (mid == 1)
          return mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private boolean isCurrentActuallyBad(int mid, Map<Integer, Boolean> map) {
    if (map.containsKey(mid)) {
      return map.get(mid);
    }
    boolean current = isBadVersion(mid);
    map.put(mid, current);
    return current;
  }
}
