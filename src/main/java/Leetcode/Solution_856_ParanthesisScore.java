package Leetcode;

class Solution_856_ParanthesisScore {
  public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    int cur = 0;
    for (char c : S.toCharArray()) {
      if (c == '(') {
        stack.push(cur);
        cur = 0;
      } else
        cur = stack.pop() + Math.max(cur * 2, 1);
    }
    return cur;
  }
}
