class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
          int exp = Arrays.binarySearch(nums, i + 1, n, nums[i]);
          System.out.println(exp);
          if(exp >= 0) return nums[i];
        }
      return 1;
    }
}