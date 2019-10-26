package Leetcode;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
    Arrays.sort(logs, (a, b) -> {
      String[] splitA = a.split(" ", 2);
      String[] splitB = b.split(" ", 2);

      boolean isDigitA = Character.isDigit(splitA[1].charAt(0));
      boolean isDigitB = Character.isDigit(splitB[1].charAt(0));

      if (isDigitA && isDigitB)
        return 0;
      if (isDigitA)
        return 1;
      if (isDigitB)
        return -1;

      int res = splitA[1].compareTo(splitB[1]);
      if (res == 0)
        res = splitA[0].compareTo(splitB[0]);
      return res;
    });

    return logs;
  }
}
