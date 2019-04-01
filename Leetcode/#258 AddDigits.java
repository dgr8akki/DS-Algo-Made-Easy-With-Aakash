class Solution {
  public int addDigits(int num) {
    if (num < 10)
      return num;
    int sum = 0;
    int temp = num;
    while (temp > 0) {
      sum += (temp % 10);
      temp /= 10;
    }
    return addDigits(sum);
  }
}
