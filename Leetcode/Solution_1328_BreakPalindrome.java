class Solution {
  public String breakPalindrome(String palindrome) {
    int count = 0;
    if (palindrome.length() < 2)
      return "";
    StringBuilder check = new StringBuilder(palindrome);
    int mid = check.length() / 2;
    for (int i = 0; i < mid; i++) {
      if (check.charAt(i) > 'a') {
        check.setCharAt(i, 'a');
        break;
      } else if (check.charAt(i) == 'a')
        count++;
      if (count == mid)
        check.setCharAt(check.length() - 1, 'b');
    }
    return check.toString();
  }
}