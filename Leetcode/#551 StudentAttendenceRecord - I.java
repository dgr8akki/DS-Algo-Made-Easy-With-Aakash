class Solution {
  public boolean checkRecord(String s) {
      int A = 0;
      for(int i = 0 ; i < s.length(); i++)
        if(s.charAt(i) == 'A') A++;
      if (A > 1) return false;
      if(s.indexOf("LLL") >= 0) return false;
    return true;
  }
}
