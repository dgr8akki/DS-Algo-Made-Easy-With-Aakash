import java.util.Scanner;

/**
 * FindPrimeSOE
 */
public class FindPrimeSOE {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int count = 0;
    int n = in.nextInt();
    in.close();
    if (n <= 2) {
      System.out.println(count);
      return;
    }

    boolean[] isNotPrime = new boolean[n];

    for (int i = 2; i < n; i++)
      if (isNotPrime[i] == false) {
        count++;
        for (int j = 2; i * j < n; j++)
          isNotPrime[i * j] = true;
      }
    System.out.println(count);
  }
}
