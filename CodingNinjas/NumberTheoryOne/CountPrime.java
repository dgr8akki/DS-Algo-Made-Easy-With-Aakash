package CodingNinjas.NumberTheoryOne;

import java.util.Scanner;

public class CountPrime {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    int count = 0;
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        count++;
      }
    }

    System.out.println(count);
  }

  private static boolean isPrime(int n) {
    int count = 0;
    for (int i = 1; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        count += 2;
      }
      if (i * i == n) {
        count--;
      }
    }
    return count == 2;
  }
}
