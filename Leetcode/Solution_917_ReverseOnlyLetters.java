package Leetcode;

class Solution_917_ReverseOnlyLetters {
  public String reverseOnlyLetters(String S) {
    Stack stack = new Stack();
    for (char ch : S.toCharArray()) {
      if (Character.isLetter(ch))
        stack.push(ch);
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < S.length(); i++) {
      if (Character.isLetter(S.charAt(i)))
        sb.append(stack.pop());
      else
        sb.append(S.charAt(i));
    }
    return sb.toString();
  }
}
