package Leetcode;

class Solution_447_Boomerrang {
  public int numberOfBoomerangs(int[][] points) {
    int res = 0;
    if (points.length < 3) {
      return 0;
    }
    for (int i = 0; i < points.length; i++) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int k = 0; k < points.length; k++) {
        int tmp = (points[i][1] - points[k][1]) * (points[i][1] - points[k][1])
            + (points[i][0] - points[k][0]) * (points[i][0] - points[k][0]);
        if (!map.containsKey(tmp)) {
          map.put(tmp, 1);
        } else {
          map.put(tmp, map.get(tmp) + 1);
        }
      }
      for (int val : map.values()) {
        if (val >= 2) {
          res += val * (val - 1);
        }
      }
    }
    return res;
  }
}
