class Solution {

  int[] nums;

  public Solution(int[] nums) {
    this.nums = nums;
  }

  public int[] reset() {
    return nums;
  }

  public int[] shuffle() {
    int size = nums.length;
    int[] res = new int[size];
    ArrayList<Integer> hat = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      hat.add(nums[i]);
    }
    int i = 0;
    while (!hat.isEmpty()) {
      Random r = new Random();
      res[i++] = hat.remove(r.nextInt(hat.size()));
    }
    return res;
  }
}
