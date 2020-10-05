/**
 * Euclid
 */
public class Euclid {

  public static int gcd(int a, int b) {
    if (b > a)
      return gcd(b, a);
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    System.out.println(gcd(11, 2));
  }
}
