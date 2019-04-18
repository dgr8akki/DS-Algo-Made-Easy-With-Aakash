class Solution {
  public int distributeCandies(int[] candies) {
    int mount = candies.length / 2;
    Set<Integer> candiesSet = new HashSet();
    for (int i = 0; i < candies.length; i++)
      candiesSet.add(candies[i]);
    return Math.min(mount, candiesSet.size());
  }
}
