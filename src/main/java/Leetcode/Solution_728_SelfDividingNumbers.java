package Leetcode;

class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> list = new ArrayList<>();
    for (int i = left; i <= right; i++)
      if (isValid(i))
        list.add(i);
    return list;
  }

  private boolean isValid(int num) {
    int temp = num;
    while (temp > 0) {
      int lastDigit = temp % 10;
      if (lastDigit == 0 || ((num % lastDigit) != 0))
        return false;
      temp /= 10;
    }

    return true;
  }
}
