class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    int stops[] = new int[1001];
    for (int t[] : trips) {
      stops[t[1]] += t[0];
      stops[t[2]] -= t[0];
    }
    for (int i = 0; capacity >= 0 && i < 1001; ++i)
      capacity -= stops[i];
    return capacity >= 0;
  }
}
