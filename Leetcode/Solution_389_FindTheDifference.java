package Leetcode;

class Solution_389_FindTheDifference {
  public char findTheDifference(String s, String t) {
    int ans = 0;
    for (char c : t.toCharArray())
      ans += c;
    for (char c : s.toCharArray())
      ans -= c;
    return (char) ans;
  }
}
// class Solution_389_FindTheDifference1 {
// public char findTheDifference(String s, String t) {
// if(s.length() < t.length()) return findTheDifference(t, s);
// StringBuilder builder = new StringBuilder(t);
// for(int i = 0 ;i < s.length(); i++)
// if(builder.indexOf("" + s.charAt(i)) < 0) return s.charAt(i);
// else builder.setCharAt(i, '1');
// return '0';
// }
// }
