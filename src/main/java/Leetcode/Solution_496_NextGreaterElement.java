package Leetcode;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      if(nums2.length == 0 || nums1.length == 0) return new int[0];
      Map<Integer, Integer> map = new HashMap<>();
      Stack<Integer> st = new Stack<>();
      st.push(nums2[0]);
      for(int i = 1; i < nums2.length; i++) {
        int num = nums2[i];
        if(num < st.peek())
          st.push(num);
        else {
          while(!st.isEmpty() && num > st.peek()) {
            map.put(st.pop(), num);
          }
          st.push(num);
        }
      }
      while(!st.isEmpty()) {
        map.put(st.pop(), -1);
      }
      int[] res = new int[nums1.length];
      for(int i = 0; i < nums1.length; i++) {
        res[i] = map.get(nums1[i]);
      }
      
      return res;
    }
}