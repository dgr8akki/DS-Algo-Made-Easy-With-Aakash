package Leetcode;

class Solution_350_IntersectionOfArrays {
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int num : nums2) {
      if (map.containsKey(num)) {
        if (map.get(num) == 1)
          map.remove(num);
        else
          map.put(num, map.get(num) - 1);
        list.add(num);
      }
    }
    int[] arr = new int[list.size()];
    int i = 0;
    for (int el : list) {
      arr[i] = el;
      i++;
    }
    return arr;
  }
}
