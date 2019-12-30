class Solution_1156_LongestRepeatingStringSwap {
  public int maxRepOpt1(String text) {
    if (text == null || text.length() == 0)
      return 0;
    int[] dic = new int[26];
    int[][] map = new int[26][2];
    for (int i = 0; i < 26; ++i) {
      map[i][0] = -1;
      map[i][1] = -1;
    }
    int pre = 0, maxc = -1, res = 0, len = text.length();
    for (int i = 0; i < len; ++i) {
      int c = text.charAt(i) - 'a';
      ++dic[c];
      if (i == len - 1 || c != text.charAt(i + 1) - 'a') {
        if (map[c][0] != -1 && pre == map[c][1] + 2) {
          if (i - map[c][0] + 1 > res) {
            res = i - map[c][0] + 1;
            maxc = c;
          }
        } else {
          if (i - pre + 2 > res) {
            res = i - pre + 2;
            maxc = c;
          }
        }
        map[c][0] = pre;
        map[c][1] = i;
        pre = i + 1;
      }
    }
    return dic[maxc] < res ? res - 1 : res;
  }
}
