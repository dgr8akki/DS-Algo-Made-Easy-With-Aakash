class Solution {
  public int minFlips(int a, int b, int c) {
    int count = 0;
    for (int i = 1; i <= 32; i++) {
      int b1 = 0, b2 = 0, b3 = 0;
      if (((a >> (i - 1)) & 1) >= 1)
        b1 = 1; // check the ith bit of a
      if (((b >> (i - 1)) & 1) >= 1)
        b2 = 1; // check the ith bit of b
      if (((c >> (i - 1)) & 1) >= 1)
        b3 = 1; // check the ith bit of c
      if (b3 == 0 && (b1 == 1 || b2 == 1))
        count += b1 + b2; // if the ith bit of c is 0 and any of the ith bits of a or b is 1
      else if (b3 == 1 && b1 == 0 && b2 == 0)
        count++; // if the ith bit of c is 1, check the ith bits of a and b
    }
    return count;
  }
}
