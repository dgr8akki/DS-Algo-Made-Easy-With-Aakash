class Solution_1177_CanMakePalindrome {
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    List<Boolean> ans = new ArrayList<>();
    int[] odds = new int[s.length() + 1];
    for (int i = 0; i < s.length(); ++i)
      odds[i + 1] = odds[i] ^ 1 << s.charAt(i) - 'a';
    for (int[] q : queries)
      ans.add(Integer.bitCount(odds[q[1] + 1] ^ odds[q[0]]) / 2 <= q[2]);
    return ans;
  }
}
