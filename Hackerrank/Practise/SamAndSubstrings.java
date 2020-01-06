package Hackerrank.Practise;

public class SamAndSubstrings {
  final static int MOD = 1_000_000_000 + 7;

  static int substrings(String n) {
    long last = 0, runningSum = 0, a = 0;
    int i = 0;

    while (i < n.length()) {
      int digit = Character.getNumericValue(n.charAt(i));
      int temp = (i + 1) * digit;
      a = (a % MOD * 10) % MOD + temp;
      runningSum = (last % MOD + a % MOD) % MOD;
      last = runningSum;
      i++;
    }
    return (int) (runningSum % MOD);

  }

  public static void main(String[] args) {
    String[] inputs = { "0", "1", "12", "123", "39249", "543" };

    for (String n : inputs) {
      int result = substrings(n);
      System.out.println(result);
    }
  }
}
