class Solution_880_DecodeAtIndex {
  public String decodeAtIndex(String S, int K) {
    for (int len = 0, i = 0; i < S.length(); i++) {
      if (Character.isDigit(S.charAt(i))) {
        int num = S.charAt(i) - '0', count = 0;
        for (; count < num - 1 && K > len; count++) {
          K -= len;
        }
        if (count != num - 1) {
          return decodeAtIndex(S, K);
        } else {
          len *= num;
        }
      } else {
        len++;
        K--;
        if (K == 0) {
          return String.valueOf(S.charAt(i));
        }
      }
    }
    return "";
  }
}
