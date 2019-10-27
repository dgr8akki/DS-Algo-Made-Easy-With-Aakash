package Leetcode;

class Solution_784_LetterPermutation {
  public List<String> letterCasePermutation(String S) {
    if (S == null || S.length() == 0)
      return new ArrayList<>();
    List<String> ret = new LinkedList<>();
    helper(S.toCharArray(), 0, ret);
    return ret;
  }

  public void helper(char[] chars, int pos, List<String> ret) {
    if (pos == chars.length) {
      ret.add(new String(chars));
      return;
    }
    if (Character.isDigit(chars[pos])) {
      helper(chars, pos + 1, ret);
      return;
    }
    chars[pos] = Character.toLowerCase(chars[pos]);
    helper(chars, pos + 1, ret);
    chars[pos] = Character.toUpperCase(chars[pos]);
    helper(chars, pos + 1, ret);
  }
}
