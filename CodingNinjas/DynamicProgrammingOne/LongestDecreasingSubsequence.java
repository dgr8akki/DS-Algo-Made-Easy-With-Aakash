package CodingNinjas.DynamicProgrammingOne;

import java.util.Arrays;

/**
 * LongestIncreasingSubsequence
 */
public class LongestDecreasingSubsequence {
  public static int getLDSLength(int[] arr, int n) {
    if(n == 0 || n == 1) return n;
    int[] lds = new int[n];
    lds[0] = 1;
    for(int i = 1; i < n; i++) {
      lds[i] = 1;
      for(int j = i - 1; j >= 0; j--) {
        if(arr[j] > arr[i]) {
          lds[i] = Math.max(lds[i], lds[j] + 1);
        }
      }
    }
    System.out.println(Arrays.toString(lds));

    int max = 0;
    for(int len : lds)
      if(len > max)
        max = len;
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {2,-1,4,3,5,-1,3,2};
    System.out.println(getLDSLength(arr, arr.length));
  }
}
