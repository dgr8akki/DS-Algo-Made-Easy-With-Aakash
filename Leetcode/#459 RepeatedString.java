class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = n / 2; i >= 1; i--) {
      if (n % i == 0) {
        int parts = n / i;
        String partString = s.substring(0, i);
        StringBuilder builder = new StringBuilder();
        for (int p = 0; p < parts; p++)
          builder.append(partString);
        if (builder.toString().equals(s))
          return true;
      }
    }
    return false;
  }
}
