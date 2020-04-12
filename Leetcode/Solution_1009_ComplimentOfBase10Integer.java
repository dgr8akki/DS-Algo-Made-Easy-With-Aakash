package Leetcode;

class Solution_1009_ComplimentOfBase10Integer {
  public int findComplement(int num) {
    String binary = Integer.toBinaryString(num);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '0')
        builder.append('1');
      else
        builder.append('0');
    }
    return Integer.parseInt(builder.toString(), 2);
  }
}
