package Leetcode;

class Solution {
  public int countSegments(String s) {
    String[] sar = s.split(" ");
    int count = 0;
    for (String word : sar) {
      if (word.length() != 0)
        count++;
    }
    return count;
  }
}
