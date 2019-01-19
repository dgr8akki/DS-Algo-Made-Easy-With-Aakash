import java.util.*;

class Solution {
  public static void PairSum(int[] input, int size) {
    Arrays.sort(input);
    boolean[] isPaired = new boolean[size];
    for (int i = 0; i < size; i++) {
      int first = input[i];
      int key = -1 * first;
      int secondIndex = binarySearch(input, 0, size - 1, key);
      if (secondIndex != -1) {
        if (!isPaired[i] || !isPaired[secondIndex]) {
          int second = input[secondIndex];
          System.out.println(first < second ? first + " " + second : second + " " + first);
          isPaired[i] = true;
          isPaired[secondIndex] = true;
        }
      }
    }
  }

  private static int binarySearch(int[] arr, int start, int end, int key) {
    if (start > end)
      return -1;
    int mid = (start + end) / 2;
    if (arr[mid] == key)
      return mid;
    if (key < arr[mid])
      return binarySearch(arr, start, mid - 1, key);
    return binarySearch(arr, mid + 1, end, key);
  }

  public static void main(String[] args) {
    int n = 1;
    int[] arr = { 2};
    PairSum(arr, n);
  }
}
