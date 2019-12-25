package Leetcode;

class Solution_921_MinimumAddToValidParan {
  public int minAddToMakeValid(String S) {
    Stack s = new Stack();
    char[] chs = S.toCharArray();
    int count = 0;
    for (char ch : chs) {
      if (ch == '(') {
        s.push(ch);
      } else {
        if (ch == ')' && !s.empty()) {
          s.pop();
        } else {
          count++;
        }
      }
    }
    return count + s.size();
  }
}
