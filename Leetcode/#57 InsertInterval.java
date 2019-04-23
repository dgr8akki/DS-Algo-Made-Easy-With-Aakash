class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] newIntervals = new int[intervals.length + 1][2];
    for (int i = 0; i < intervals.length; i++)
      newIntervals[i] = intervals[i];
    newIntervals[newIntervals.length - 1] = newInterval;
    return merge(newIntervals);
  }

  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0)
      return new int[0][0];
    java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });

    List<List<Integer>> temp = new ArrayList<>();
    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int[] interval : intervals) {
      if (interval[0] <= end)
        end = Math.max(end, interval[1]);
      else {
        List<Integer> x = new ArrayList<Integer>();
        x.add(start);
        x.add(end);
        temp.add(x);
        start = interval[0];
        end = interval[1];
      }
    }
    List<Integer> x = new ArrayList<Integer>();
    x.add(start);
    x.add(end);
    temp.add(x);

    int[][] res = new int[temp.size()][2];
    for (int i = 0; i < temp.size(); i++) {
      res[i][0] = temp.get(i).get(0);
      res[i][1] = temp.get(i).get(1);
    }
    return res;
  }
}
