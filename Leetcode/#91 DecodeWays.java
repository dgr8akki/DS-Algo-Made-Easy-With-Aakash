class Solution {
  final static int M = 1_000_000_000 + 7;

  public int numDecodings(String s) {
    int length = s.length();
    int[] counts = new int[length + 1];
    counts[0] = 1;
    counts[1] = 1;
    for (int i = 2; i <= length; i++) {
      counts[i] = counts[i - 1];
      if (s.charAt(i - 1) == '0') {
        counts[i] = 0;
      }
      int alphabetIndex = Character.getNumericValue(s.charAt(i - 2)) * 10 + Character.getNumericValue(s.charAt(i - 1));
      if (alphabetIndex >= 10 && alphabetIndex <= 26)
        counts[i] = (counts[i] % M + counts[i - 2] % M) % M;
    }
    if (s.charAt(0) == '0')
      return 0;

    return counts[length] % M;
  }
}
