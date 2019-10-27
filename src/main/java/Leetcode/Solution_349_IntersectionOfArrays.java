package Leetcode;

class Solution_349_IntersectionOfArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return intersection(nums2, nums1);
        Set<Integer> list = new HashSet<>();
        Arrays.sort(nums2);
        for(int num: nums1) {
          if(Arrays.binarySearch(nums2, num) >= 0)
            list.add(num);
        }
      int[] arr = new int[list.size()];
      int i = 0;
      for(int el : list) {
        arr[i] = el;
        i++;
      }
      return arr;
    }
}