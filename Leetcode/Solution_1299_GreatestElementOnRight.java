class Solution_1299_GreatestElementOnRight {
  public int[] replaceElements(int[] arr) {
    if (arr.length <= 1) {
      return new int[] { -1 };
    }

    int length = arr.length - 1;
    int curMax = Math.max(arr[length], arr[length - 1]);

    int[] result = new int[arr.length];
    result[length - 1] = arr[length];
    result[length] = -1;

    for (int i = length - 2; i >= 0; i--) {
      result[i] = curMax;
      curMax = Math.max(curMax, arr[i]);
    }

    return result;
  }
}
