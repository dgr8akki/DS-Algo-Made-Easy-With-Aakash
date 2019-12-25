package main.java.Leetcode;

/**
 * Solution_1243_Array_Transformation
 */
public class Solution_1243_Array_Transformation {

  public List<Integer> transformArray(int[] arr) {
    int[] ans = new int[arr.length];
    while (!Arrays.equals(ans, arr)) {
      ans = arr.clone();
      for (int i = 1; i < arr.length - 1; ++i) {
        if (ans[i - 1] < ans[i] && ans[i] > ans[i + 1]) {
          --arr[i];
        } else if (ans[i - 1] > ans[i] && ans[i] < ans[i + 1]) {
          ++arr[i];
        }
      }
    }
    return Arrays.stream(ans).boxed().collect(Collectors.toList());
  }
}
