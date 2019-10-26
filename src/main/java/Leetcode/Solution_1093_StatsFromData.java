package Leetcode;

class Solution {
  public double[] sampleStats(int[] count) {
    int total = 0, mode = 0;
    double median = 0, min = -1, max = 0, avg = 0, sum = 0;
    for (int i = 0; i < 256; ++i) {
      if (count[i] > 0) {
        total += count[i];
        if (min < 0)
          min = i;
        max = i;
        sum += i * count[i];
        if (count[i] > count[mode])
          mode = i;
      }
    }
    avg = sum / total;
    if (total == 1)
      median = sum;
    int m1 = (total + 1) / 2, m2 = total / 2 + 1;
    for (int i = 0, cnt = 0; total > 1 && i < 256; ++i) {
      if (cnt < m1 && cnt + count[i] >= m1)
        median += i / 2.0d;
      if (cnt < m2 && cnt + count[i] >= m2)
        median += i / 2.0d;
      cnt += count[i];
    }
    return new double[] { min, max, avg, median, mode };
  }
}
