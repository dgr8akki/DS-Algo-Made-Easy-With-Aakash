package DsAlgoMadeEasyInJava.Reccursion;

import java.util.Arrays;

public class IsArraySorted {
  public static boolean check(int[] arr) {
    return check(arr, 0);
  }

  private static boolean check(int[] arr, int currentIndex) {
    if (arr.length == 1 || currentIndex == arr.length - 1) {
      return true;
    }
    return arr[currentIndex] <= arr[currentIndex + 1] ? check(arr, currentIndex + 1) : false;
  }

  public static void main(String[] args) {
    int[] arr2 = {1, 2, 3, 4, 0, 5, 6, 9};
    int[] arr = {1, 2, 3, 4, 5, 5, 6, 9};
    System.out.println("Is Array " + Arrays.toString(arr2) + " sorted?");
    System.out.println(check(arr2));
    System.out.println("Is Array " + Arrays.toString(arr) + " sorted?");
    System.out.println(check(arr));
  }
}
