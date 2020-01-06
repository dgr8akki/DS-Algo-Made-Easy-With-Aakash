package Leetcode;

class Solution_482_LicenceKeyFormatting {
  public String licenseKeyFormatting(String S, int K) {
    int strLen = 0, i = 0, n = S.length();

    while (i < n)
      if (S.charAt(i++) != '-')
        strLen++;
    if (strLen == 0)
      return "";
    int firstPartLen = strLen % K == 0 ? K : strLen % K;
    int parts = (strLen / K);
    i = 0;
    StringBuilder builder = new StringBuilder();
    for (; i < n; i++) {
      if (S.charAt(i) != '-')
        builder.append(Character.toUpperCase(S.charAt(i)));
      if (builder.length() == firstPartLen) {
        builder.append('-');
        i++;
        break;
      }
    }
    // System.out.println(builder.toString());
    for (int p = 0; p < parts; p++) {
      int count = 0;
      for (; i < n; i++) {
        if (S.charAt(i) != '-') {
          builder.append(Character.toUpperCase(S.charAt(i)));
          count++;
        } else
          continue;
        if (count == K) {
          builder.append('-');
          i++;
          // System.out.println(builder.toString());
          break;
        }
      }

    }
    builder.deleteCharAt(builder.length() - 1);
    return builder.toString();
  }
}
