package CodingNinjas.LanguageToolsAndTimeComplexity;

import java.util.Arrays;

public class TripletSum {

  public static void FindTriplet(int[] arr, int x) {
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (arr[i] + arr[j] + arr[k] == x) {
            System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
          }
        }
      }
    }
  }
}
