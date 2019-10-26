package CodingNinjas.DynamicProgrammingOne;

import java.util.Arrays;

/**
 * LargestBitonicSubarray
 */
public class LargestBitonicSubarray {
  public static int longestBitonicSubarray(int[] arr) {
    int n = arr.length;
    if(n == 0 || n == 1 || n == 2) return n;
    int[] lis = new int[n];
    int[] lds = new int[n];
    lis[0] = 1;
    lds[n - 1] = 1;
    for(int i = 1; i < n; i++) {
      lis[i] = 1;
      for(int j = i - 1; j >= 0; j--) {
        if(arr[j] < arr[i]) {
          lis[i] = Math.max(lis[i], lis[j] + 1);
        }
      }
    }

    for(int i = n - 2; i >= 0; i--) {
      lds[i] = 1;
      for(int j = i + 1; j < n; j++) {
        if(arr[j] < arr[i]) {
          lds[i] = Math.max(lds[i], lds[j] + 1);
        }
      }
    }

    int max = 0;
    for(int i = 0; i < n; i++) {
      max = Math.max(max, lis[i] + lds[i]);
    }
    return max - 1;
  }
  public static void main(String[] args) {
    int[] arr = {2,-1,4,3,5,-1,3,2};
    System.out.println(longestBitonicSubarray(arr));
  }
}