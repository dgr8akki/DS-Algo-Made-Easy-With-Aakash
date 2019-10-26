package Leetcode;

class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length, start = 0, end = n - 1, mid = -1, res;
    while (start <= end) {
      mid = (start + end) / 2;
      if (target >= letters[mid])
        start = mid + 1;
      else
        end = mid - 1;
    }
    res = start;

    if (res >= letters.length)
      return letters[0];
    else if (letters[res] == target)
      res++;
    return letters[res >= letters.length ? 0 : res];
  }
}
