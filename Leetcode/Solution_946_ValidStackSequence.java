package Leetcode;

class Solution_946_ValidStackSequence {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stk = new Stack<>();
    int i = 0;
    for (int p : pushed) {
      stk.push(p);
      while (!stk.isEmpty() && stk.peek() == popped[i]) {
        stk.pop();
        ++i;
      }
    }
    return stk.empty();
  }
}
