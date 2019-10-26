package Leetcode;

class Solution {
  public int binaryGap(int N) {
    String bin = Integer.toBinaryString(N);
    int count = 0, maxCount = 0;
    boolean oneEncountered = false;
    for (int i = 0; i < bin.length(); i++) {
      if (bin.charAt(i) == '0' && oneEncountered)
        count++;
      else if (bin.charAt(i) == '1') {
        if (oneEncountered) {
          maxCount = Math.max(maxCount, count);
          count = 1;
        } else
          count++;
        oneEncountered = true;
      }
    }
    return maxCount;
  }
}
