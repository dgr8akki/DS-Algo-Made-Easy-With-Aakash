class Solution {
  public int findShortestSubArray(int[] nums) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);

        map.put(nums[i], list);
      } else {
        ArrayList<Integer> list = map.get(nums[i]);
        list.add(i);

      }
    }

    int count = 0;

    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      int key = entry.getKey();
      ArrayList<Integer> list = entry.getValue();

      if (list.size() > count) {
        count = list.size();
      }
    }

    int min = nums.length;

    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      ArrayList<Integer> list = entry.getValue();

      if (list.size() == count) {
        int len = list.get(list.size() - 1) - list.get(0) + 1;

        if (len < min) {
          min = len;
        }
      }
    }

    return min;
  }
}
