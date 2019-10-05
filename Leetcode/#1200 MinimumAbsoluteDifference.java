class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();
    int minDiff = Math.abs(arr[0] - arr[1]);
    for (int i = 0; i < arr.length - 1; i++) {
      int currDiff = Math.abs(arr[i] - arr[i + 1]);
      minDiff = Math.min(minDiff, currDiff);
    }
    for (int i = 0; i < arr.length - 1; i++) {
      int currDiff = Math.abs(arr[i] - arr[i + 1]);
      if (minDiff == currDiff) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[i]);
        list.add(arr[i + 1]);
        result.add(list);
      }
    }
    return result;
  }
}
