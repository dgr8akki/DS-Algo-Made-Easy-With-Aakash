package CodingNinjas.DynamicProgrammingOne;

import java.util.Scanner;

/**
 * StairCase
 */
public class StairCase {
  public static long staircase(int n) {
    long[] arr = new long[n + 1];
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 2;
    for(int i = 3; i <= n; i++) {
      arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
    }
    return arr[n];
	}

  public static long staircaseRecursive(int n) {
    if(n == 0 || n == 1) return 1;
    if(n == 2) return 2;
    return staircaseRecursive(n - 1) + staircaseRecursive(n - 2) + staircaseRecursive(n - 3);
	}

  public static long staircaseMemoized(int n, long[] arr) {
    if(n == 0 || n == 1) return 1;
    if(n == 2) return 2;
    if(arr[n] > 0) return arr[n];
    arr[n] = staircaseMemoized(n - 1, arr) + staircaseMemoized(n - 2, arr) + staircaseMemoized(n - 3, arr);
    return arr[n];
	}

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    System.out.println(staircaseRecursive(n));
    long[] arr = new long[n + 1];
    System.out.println(staircaseMemoized(n, arr));
    System.out.println(staircase(n));
  }
}