package CodingNinjas.LanguageToolsAndTimeComplexity;

import java.util.Arrays;

public class ArrayRotate {

  public static void rotate(int[] arr, int d) {
    int n = arr.length;

    // Put first d elements into another array.
    int[] temp = Arrays.copyOfRange(arr, 0, d);

    // Move n - d elements towards left.
    for (int i = d; i < n; i++) {
      swap(arr, i, i - d);
    }

    // Add leftover elements back to original array.
    for (int i = n - d; i < n; i++) {
      arr[i] = temp[i - (n - d)];
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
