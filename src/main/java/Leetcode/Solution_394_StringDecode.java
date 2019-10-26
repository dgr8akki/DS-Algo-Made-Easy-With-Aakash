package Leetcode;

class Solution {
  public String decodeString(String str) {
    Stack<Character> s = new Stack<Character>();
    int index = 0;
    while (index < str.length()) {
      char ch = str.charAt(index++);
      if (ch != ']')
        s.push(ch);
      else {
        String sp = "";
        while (!s.isEmpty() && s.peek() != '[')
          sp = s.pop() + sp;
        s.pop();

        String countS = "";
        while (!s.isEmpty() && Character.isDigit(s.peek()))
          countS = s.pop() + countS;
        int count = Integer.parseInt(countS);

        for (int i = 1; i <= count; i++)
          for (int j = 0; j < sp.length(); j++)
            s.push(sp.charAt(j));

      }
    }
    StringBuffer sb = new StringBuffer();
    while (!s.isEmpty())
      sb.append(s.pop());
    return sb.reverse().toString();
  }
}
