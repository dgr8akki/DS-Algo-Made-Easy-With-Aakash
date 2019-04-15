class Solution {
  public String reverseWords(String s) {
    String[] sar = s.split(" ");
    StringBuilder builder = new StringBuilder();
    String prefix = "";
    for (int i = 0; i < sar.length; i++) {
      String temp = new StringBuilder(sar[i]).reverse().toString();
      // builder.append(temp).append(" ");

      builder.append(prefix);
      prefix = " ";
      builder.append(temp);
    }
    // System.out.println(sar[0]);
    return builder.toString();
  }
}
