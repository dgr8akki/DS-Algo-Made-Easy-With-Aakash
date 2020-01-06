package CodingNinjas.BacktrackingBinarySearchAssignment;

import java.util.Scanner;

public class Power {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int n = in.nextInt();
    System.out.println(pow(x, n));
  }

  private static long pow(int x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (x == 0) {
      return 0;
    }
    if (n % 2 == 1) {
      return x * pow(x, n - 1);
    }
    return pow(x * x, n / 2);
  }
}
