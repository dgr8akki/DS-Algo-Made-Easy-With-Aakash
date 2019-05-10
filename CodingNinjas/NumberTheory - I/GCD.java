/**
 * GCD
 */
public class GCD {

  public static int gcd(int a, int b) {
    if (b > a)
      return gcd(b, a);
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }
}
