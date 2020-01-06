class Solution_1249_MinimumRemoveToValidParanthesis {
  public String minRemoveToMakeValid(String s) {
    StringBuilder builder = new StringBuilder();
    int braces = 0;
    for (char c : s.toCharArray()) {
      if (c == '(')
        braces++;
      else if (c == ')') {
        if (braces == 0)
          continue;
        braces--;
      }
      builder.append(c);
    }

    StringBuilder result = new StringBuilder();
    for (int i = builder.length() - 1; i >= 0; i--) {
      if (builder.charAt(i) == '(' && braces-- > 0)
        continue;
      result.append(builder.charAt(i));
    }

    return result.reverse().toString();
  }
}
