package Leetcode;

class Solution {
  public List<String> readBinaryWatch(int num) {
    List<String> res = new ArrayList<>();
    for (int h = 0; h < 12; h++) {
      int numInH = onesInNumber(h);
      for (int m = 0; m < 60; m++) {
        int numInM = onesInNumber(m);
        if (numInH + numInM != num)
          continue;
        String min = m < 10 ? ("0" + m) : ("" + m);
        res.add(h + ":" + min);
      }
    }
    return res;
  }

  private int onesInNumber(int n) {
    int count = 0;
    while (n > 0) {
      if (n % 2 == 1)
        count++;
      n /= 2;
    }
    return count;
  }
}
