class Solution {
  public int expressiveWords(String S, String[] words) {
    int res = 0;
    for (String W : words)
      if (check(S, W))
        res++;
    return res;
  }

  public boolean check(String S, String W) {
    int n = S.length(), m = W.length(), j = 0;
    for (int i = 0; i < n; i++)
      if (j < m && S.charAt(i) == W.charAt(j))
        j++;
      else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2))
        ;
      else if (0 < i && i < n - 1 && S.charAt(i - 1) == S.charAt(i) && S.charAt(i) == S.charAt(i + 1))
        ;
      else
        return false;
    return j == m;
  }
}
