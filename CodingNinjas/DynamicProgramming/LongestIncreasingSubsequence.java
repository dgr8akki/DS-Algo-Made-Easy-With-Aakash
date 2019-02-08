/**
 * LongestIncreasingSubsequence
 */
public class LongestIncreasingSubsequence {
  public static int getLISLength(int[] arr, int n) {
    if(n == 0 || n == 1) return n;
    int[] lis = new int[n];
    lis[0] = 1;
    for(int i = 1; i < n; i++) {
      lis[i] = 1;
      for(int j = i - 1; j >= 0; j--) {
        if(arr[j] < arr[i]) {
          lis[i] = Math.max(lis[i], lis[j] + 1);
        }
      }
    }

    int max = 0;
    for(int len : lis)
      if(len > max)
        max = len;
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {4,3,9,7,6,8,20};
    System.out.println(getLISLength(arr, arr.length));
  }
}