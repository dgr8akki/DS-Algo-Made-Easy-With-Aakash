class Solution {
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    List<int[]> list = new ArrayList<int[]>();
    for (int[] rest : restaurants) {
      boolean cond1 = (veganFriendly == 0 || (veganFriendly == rest[2]));
      boolean cond2 = rest[3] <= maxPrice;
      boolean cond3 = rest[4] <= maxDistance;
      if (cond1 && cond2 && cond3)
        list.add(rest);
    }
    Collections.sort(list, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        if (a[1] == b[1])
          return b[0] - a[0];
        else
          return b[1] - a[1];
      }
    });
    List<Integer> ans = new ArrayList<>();
    for (int[] rest : list)
      ans.add(rest[0]);
    return ans;
  }
}
