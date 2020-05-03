package Leetcode;

class Solution_383_RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null && magazine == null)
      return true;
    if (ransomNote == null || magazine == null)
      return false;
    if (magazine.length() < ransomNote.length())
      return false;
    char[] dict = new char[26];
    for (char c : magazine.toCharArray())
      dict[c - 97]++;
    for (char c : ransomNote.toCharArray()) {
      if (dict[c - 97] <= 0)
        return false;
      dict[c - 97]--;
    }
    return true;
  }
}
