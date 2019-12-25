class Solution_1297_OccuranceMaximum {
  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    Map<String, Integer> res = new HashMap<>();
    int n = s.length(), resCnt = 0;
    if (minSize > n)
      return 0;
    for (int i = 0; i < n; i++) {
      Map<Character, Integer> map = new HashMap<>();
      for (int distNum = 0, j = 0; j < maxSize; j++) {
        if (i + j >= n)
          break;
        map.put(s.charAt(i + j), map.getOrDefault(s.charAt(i + j), 0) + 1);
        if (map.get(s.charAt(i + j)) == 1)
          distNum++;
        if (distNum > maxLetters)
          break;
        if (j >= minSize - 1)
          res.put(s.substring(i, i + j + 1), res.getOrDefault(s.substring(i, i + j + 1), 0) + 1);
      }
    }
    for (String str : res.keySet()) {
      if (res.get(str) > resCnt)
        resCnt = res.get(str);
    }
    return resCnt;
  }
}
