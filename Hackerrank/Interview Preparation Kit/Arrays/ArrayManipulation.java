import java.util.*;

public class ArrayManipulation {
  static long[] arr;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    arr = new long[n + 1];
    arr = fillArrayWithZeros(n);
    int m = in.nextInt();
    for (int a0 = 0; a0 < m; a0++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int k = in.nextInt();
      updateArray(a, b, k);
    }
    in.close();

    System.out.print(maxInArray());
  }

  public static long[] fillArrayWithZeros(int n) {
    long[] temp = new long[n + 1];
    for (int i = 1; i <= n; i++)
      temp[i] = 0;
    return temp;
  }

  public static void updateArray(int a, int b, int k) {
    arr[a - 1] += k;
    if (b < arr.length) {
      arr[b] -= k;
    }
  }

  public static long maxInArray() {
    long maxNumber = Long.MIN_VALUE;
    long number = 0;
    for (int i = 0; i < arr.length; i++) {
      number += arr[i];
      maxNumber = Math.max(maxNumber, number);
    }
    return maxNumber;
  }
}
