package Leetcode;

public class Solution_227_BasicCalc2 {
  public int calculate(String s) {
    int len;
    if (s == null || (len = s.length()) == 0)
      return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for (int i = 0; i < len; i++) {
      char currentCharacter = s.charAt(i);
      if (Character.isDigit(currentCharacter))
        num = num * 10 + currentCharacter - '0';

      if ((!Character.isDigit(currentCharacter) && ' ' != currentCharacter) || i == len - 1) {
        if (sign == '-')
          stack.push(-num);
        if (sign == '+')
          stack.push(num);
        if (sign == '*')
          stack.push(stack.pop() * num);
        if (sign == '/')
          stack.push(stack.pop() / num);
        sign = currentCharacter;
        num = 0;
      }
    }

    int result = 0;
    for (int currentNum : stack)
      result += currentNum;

    return result;
  }
}
