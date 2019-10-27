package Leetcode;

class Solution_481_MagicStrings {
  public int magicalString(int n) {
    List<Integer> nums = new ArrayList();
    nums.add(1);
    nums.add(2);
    nums.add(2);
    int repIndex = 2, i = 3, num = 1, count = 0;
    while (i < n) {
      int repeat = nums.get(repIndex);
      repIndex++;
      if (repeat == 1) {
        nums.add(num);
        i++;
      } else {
        nums.add(num);
        nums.add(num);
        i += 2;
      }
      num ^= 3;
    }

    for (i = 0; i < n; i++)
      if (nums.get(i) == 1)
        count++;
    return count;
  }
}
