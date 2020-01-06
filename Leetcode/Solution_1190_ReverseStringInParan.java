package Leetcode;

class Solution_1190_ReverseStringInParan {
  public String reverseParentheses(String s) {
    int n = s.length();
    Stack<Integer> opened = new Stack<>();
    int[] pair = new int[n];
    for (int i = 0; i < n; ++i) {
      if (s.charAt(i) == '(')
        opened.push(i);
      if (s.charAt(i) == ')') {
        int j = opened.pop();
        pair[i] = j;
        pair[j] = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0, d = 1; i < n; i += d) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        i = pair[i];
        d = -d;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
