package Leetcode;

class Solution_506_RelativeRanks {
  public String[] findRelativeRanks(int[] nums) {
    String[] medals = { "Gold Medal", "Silver Medal", "Bronze Medal" };
    String[] result = new String[nums.length];
    int[] copy = Arrays.copyOf(nums, nums.length);
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.sort(copy);
    for (int i = 0; i < nums.length; i++) {
      map.put(copy[i], nums.length - 1 - i);
    }

    int rank = 0;
    for (int i = 0; i < nums.length; i++) {
      rank = map.get(nums[i]);
      result[i] = rank < 3 ? medals[rank] : String.valueOf(rank + 1);
    }

    return result;
  }
}
