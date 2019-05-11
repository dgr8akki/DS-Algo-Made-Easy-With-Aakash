class Solution {
  private Map<String, Integer> map = new HashMap<>();

  public int change(int amount, int[] coins) {
    if (amount == 0)
      return 1;
    if (coins == null || coins.length == 0)
      return 0;

    Arrays.sort(coins);
    return find(coins, amount);
  }

  private int find(int[] coins, int amount) {
    if (amount == 0)
      return 1;
    if (coins.length == 1)
      return amount % coins[0] == 0 ? 1 : 0;

    String key = coins.length + "-" + amount;
    if (map.containsKey(key))
      return map.get(key);

    int last = coins[coins.length - 1];
    int res = 0;
    if (amount >= last) {
      int use = find(coins, amount - last);
      int notUse = find(Arrays.copyOfRange(coins, 0, coins.length - 1), amount);
      res = use + notUse;
    } else {
      res = find(Arrays.copyOfRange(coins, 0, coins.length - 1), amount);
    }

    map.put(key, res);
    return res;
  }
}
