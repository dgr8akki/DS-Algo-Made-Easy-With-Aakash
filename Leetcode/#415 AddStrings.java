class Solution {
  public String addStrings(String num1, String num2) {
    int carry = 0;
    int val = 0;
    int l1 = num1.length() - 1;
    int l2 = num2.length() - 1;
    StringBuilder builder = new StringBuilder();
    while (l1 >= 0 || l2 >= 0) {
      int a = l1 < 0 ? 0 : Character.getNumericValue(num1.charAt(l1));
      int b = l2 < 0 ? 0 : Character.getNumericValue(num2.charAt(l2));
      val = (carry + a + b) % 10;
      carry = (carry + a + b) / 10;
      builder.append(val);
      l1--;
      l2--;
    }
    if (carry != 0)
      builder.append(carry);
    return builder.reverse().toString();
  }
}