public class Solution {
  public String reverseStr(String s, int k) {
    StringBuilder sb = new StringBuilder();

    int i = 0, j = 0;
    while (i < s.length()) {
      j = i + k <= s.length() ? i + k : s.length();
      sb.append((new StringBuilder(s.substring(i, j))).reverse().toString());

      if (j >= s.length())
        break;

      i = j;
      j = i + k <= s.length() ? i + k : s.length();
      sb.append(s.substring(i, j));
      i = j;
    }
    return sb.toString();
  }
}
