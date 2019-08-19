class Solution {
  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, Integer> map = new TreeMap();
    for (int i = 0; i < intervals.length; i++)
      map.put(intervals[i][0], i);

    int[] arr = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      Integer key = map.ceilingKey(intervals[i][1]);
      arr[i] = (key != null ? map.get(key) : -1);
    }
    return arr;
  }
}
