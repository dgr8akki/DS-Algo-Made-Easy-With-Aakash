class Solution {
  public String frequencySort(String s) {
    int[][] counts = new int[256][2];
    for (int i = 0; i < s.length(); i++) {
      counts[s.charAt(i)][0] = s.charAt(i);
      counts[s.charAt(i)][1]++;
    }

    Arrays.sort(counts, (a, b) -> (b[1] - a[1]));

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < counts.length; i++) {
      while (counts[i][1] > 0) {
        sb.append((char) counts[i][0]);
        counts[i][1]--;
      }
    }
    return sb.toString();
  }
}
