import java.util.Scanner;

/**
 * SquareBrackets
 */
public class SquareBrackets {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int d = in.nextInt();
    while(d-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      boolean[] isOnlyOpenNeededHere = new boolean[(2 * n) + 1];
      while(k-- > 0)
        isOnlyOpenNeededHere[in.nextInt() - 1] = true;
      System.out.println(solve(n, isOnlyOpenNeededHere));
    }
    in.close();
  }

  private static int solve(int n, boolean[] isOnlyOpenNeededHere) {
    return squareBracketUtil(n, isOnlyOpenNeededHere, 0, 0);
  }

  private static int squareBracketUtil(int n, boolean[] isOnlyOpenNeededHere, int currentOpeningCount, int currentClosingCount) {
    if(currentClosingCount > n || currentOpeningCount > n) return 0;
    if(currentClosingCount == n && currentOpeningCount == n) return 1;

    //Only opening bracket.
    if(currentClosingCount == currentOpeningCount || isOnlyOpenNeededHere[currentClosingCount + currentOpeningCount]) {
      return squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount + 1, currentClosingCount);
    }
    //Only closing bracket.
    if(currentOpeningCount == n) {
      return squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount, currentClosingCount + 1);
    }
    //Both can be apply
    return squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount, currentClosingCount + 1)
    + squareBracketUtil(n, isOnlyOpenNeededHere, currentOpeningCount + 1, currentClosingCount);
  }
}
