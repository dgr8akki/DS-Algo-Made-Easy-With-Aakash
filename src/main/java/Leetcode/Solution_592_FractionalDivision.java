package Leetcode;

class Solution {
  public String fractionAddition(String expression) {
    Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
    int A = 0, B = 1;
    while (sc.hasNext()) {
      int a = sc.nextInt(), b = sc.nextInt();
      A = A * b + a * B;
      B *= b;
      int g = gcd(A, B);
      A /= g;
      B /= g;
    }
    return A + "/" + B;
  }

  private int gcd(int a, int b) {
    return a != 0 ? gcd(b % a, a) : Math.abs(b);
  }
}
