class Solution_1287_AppearingMoreThan25Percent {
  public int findSpecialInteger(int[] arr) {
    int n = arr.length;
    int count = 1;
    int e = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] == e)
        count++;
      else {
        e = arr[i];
        count = 1;
      }
      if (count > n / 4)
        return arr[i];
    }
    return e;
  }
}
