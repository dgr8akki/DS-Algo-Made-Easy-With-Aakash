class Solution {
  public int[] arrayRankTransform(int[] arr) {
    if (arr == null || arr.length == 0)
      return arr;
    int[] ans = new int[arr.length];
    Map<Integer, Integer> map = new HashMap<>();
    int[] temp = arr.clone();
    Arrays.sort(temp);
    int j = 1;
    for (int i = 0; i < temp.length; i++)
      if (!map.containsKey(temp[i]))
        map.put(temp[i], j++);

    if (map.isEmpty())
      return null;
    for (int i = 0; i < arr.length; i++)
      ans[i] = map.get(arr[i]);

    return ans;
  }
}
