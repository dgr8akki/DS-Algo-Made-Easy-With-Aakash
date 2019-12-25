package Leetcode;

class Solution_179_LargestNumber {
  public String largestNumber(int[] num) {
    StringBuilder res = new StringBuilder();
    if (num == null || num.length == 0)
      return null;
    String[] nums = new String[num.length];
    for (int i = 0; i < num.length; i++)
      nums[i] = Integer.toString(num[i]);
    Comparator<String> comp = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o1 + o2).compareTo(o2 + o1);
      }
    };
    Arrays.sort(nums, comp);
    if (nums[nums.length - 1].equals("0"))
      return "0";

    for (int i = nums.length - 1; i >= 0; i--)
      res.append(nums[i]);
    return res.toString();
  }
}
