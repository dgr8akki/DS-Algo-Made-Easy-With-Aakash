package Leetcode;

class Solution_520_DetectCapital {
  public boolean detectCapitalUse(String word) {
    int capsCount = 0;
    int n = word.length();
    for (int i = 0; i < n; i++)
      if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
        capsCount++;
    return (capsCount == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') || capsCount == 0 || capsCount == n;
  }
}
