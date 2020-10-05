public class Solution_402_Remove_K_digits {

  public String removeKdigits(String num, int k) {
    int len = num.length();
    if (k == 0)
      return num;
    if (k == len)
      return "0";

    Stack<Character> stack = new Stack<>();
    int index = 0;

    while (index < len) {
      while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
        stack.pop();
        k--;
      }
      stack.push(num.charAt(index++));
    }
    while (k-- > 0)
      stack.pop();

    String smallest = "";
    while (!stack.isEmpty())
      smallest = stack.pop() + smallest;

    while (smallest.length() > 1 && smallest.charAt(0) == '0')
      smallest = smallest.substring(1);

    return smallest;
  }
}
