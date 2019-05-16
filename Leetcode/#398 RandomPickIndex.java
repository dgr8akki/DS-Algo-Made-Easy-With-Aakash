class Solution {
  HashMap<Integer, List<Integer>> map;

  public Solution(int[] nums) {
    map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.get(nums[i]).add(i);
      } else {
        List<Integer> list = new ArrayList();
        list.add(i);
        map.put(nums[i], list);
      }
    }
  }

  public int pick(int target) {
    int randIndex = (int) (Math.random() * map.get(target).size());
    return map.get(target).get(randIndex);
  }
}
