class Solution_1309_DecryptStringAlphabet {
  public String freqAlphabets(String s) {
    StringBuilder builder = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      int rank = 96;

      if (c == '#') {
        rank += Integer.parseInt(s.substring(i - 2, i));
        i -= 2;
      } else
        rank += Integer.parseInt(s.charAt(i) + "");
      builder.append((char) rank);
    }
    return builder.reverse().toString();
  }
}
