class Solution {
  public boolean isValid(String S) {
    Stack<Character> stack = new Stack<>();
    for (char c : S.toCharArray()) {
      if (c == 'c') {
        if (!stack.isEmpty() && stack.peek() == 'b') {
          stack.pop();
          if (!stack.isEmpty() && stack.peek() == 'a') {
            stack.pop();
          }
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
