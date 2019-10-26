package Leetcode;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    if (s.length() == 0)
      return true;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
      case '(':
      case '{':
      case '[':
        st.push(c);
        break;
      case ')':
        if (!st.isEmpty() && st.peek() == '(') {
          st.pop();
          break;
        } else
          return false;
      case '}':
        if (!st.isEmpty() && st.peek() == '{') {
          st.pop();
          break;
        } else
          return false;
      case ']':
        if (!st.isEmpty() && st.peek() == '[') {
          st.pop();
          break;
        } else
          return false;
      }
    }
    return st.isEmpty();
  }
}
