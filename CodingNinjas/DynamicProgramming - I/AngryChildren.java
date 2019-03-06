import java.util.Arrays;
import java.util.Scanner;

/**
 * AngryChildren
 */
public class AngryChildren {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    long[] arr = new long[n];
    for(int i = 0; i < n; i++)
      arr[i] = in.nextLong();
    in.close();
    Arrays.sort(arr);
    long target = 0;
    long sum = arr[0];
    for(int i = 1; i < k; i++) {
      target += ((i * arr[i]) - sum);
      sum += arr[i];
    }
    long res = target;
    for (int i = k; i < n; i++) {
      sum -= arr[i-k];
      target -= (sum - (k-1) * arr[i-k]);
      target += ((k-1) * arr[i] - sum);
      res = Math.min(target, res);
      sum += arr[i];
    }
    System.out.println(res);
  }
}
