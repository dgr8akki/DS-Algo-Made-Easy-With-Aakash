class Solution {
  public boolean rotateString(String A, String B) {
      StringBuilder sb = new StringBuilder(A);
      int count = 0;
      if(A.length()==0&&B.length()==0)
          return true;
      while(count<sb.length()){
          char c = sb.charAt(0);
          sb.deleteCharAt(0);
          sb.append(c);
          if(sb.toString().equals(B))
              return true;
          count++;
      }
      return false;
  }
}
