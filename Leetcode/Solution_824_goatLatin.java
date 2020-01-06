package Leetcode;

class Solution_824_goatLatin {
  public String toGoatLatin(String s) {
    String[] sar = s.split(" ");
    List<Character> vowels = new ArrayList<>();
    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');
    vowels.add('A');
    vowels.add('E');
    vowels.add('I');
    vowels.add('O');
    vowels.add('U');
    StringBuilder builder = new StringBuilder();
    String prefix = "";
    for (int i = 0; i < sar.length; i++) {
      String temp = getGoatWord(sar[i], i, vowels);
      // builder.append(temp).append(" ");

      builder.append(prefix);
      prefix = " ";
      builder.append(temp);
    }
    // System.out.println(sar[0]);
    return builder.toString();
  }

  private String getGoatWord(String S, int i, List<Character> vowels) {
    StringBuilder builder = new StringBuilder(S);
    if (vowels.contains(S.charAt(0)))
      builder.append("ma");
    else
      builder.deleteCharAt(0).append(S.charAt(0)).append("ma");

    for (int j = 0; j <= i; j++)
      builder.append("a");
    return builder.toString();
  }
}
