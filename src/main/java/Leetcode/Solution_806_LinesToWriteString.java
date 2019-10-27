package Leetcode;

class Solution_806_LinesToWriteString {
  public int[] numberOfLines(int[] widths, String S) {
    int[] res = new int[2];
    int lineCount = 1;
    int widthCount = 0;
    for (char c : S.toCharArray()) {
      int charIndex = ((int) c) - 97;
      int charWidth = widths[charIndex];
      if (widthCount + charWidth > 100) {
        lineCount++;
        widthCount = charWidth;
      } else {
        widthCount += charWidth;
      }
    }
    res[0] = lineCount;
    res[1] = widthCount;
    return res;
  }
}
