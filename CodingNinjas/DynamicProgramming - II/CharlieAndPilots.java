import java.util.Scanner;

/**
 * CharlieAndPilots
 */
public class CharlieAndPilots {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] captainSalaries = new int[n];
    int[] assistantSalaries = new int[n];
    int[] sumOfCaptainSalaries = new int[n];
    for (int i = 0; i < n; i++) {
      captainSalaries[i] = in.nextInt();
      assistantSalaries[i] = in.nextInt();
      if(i == 0)
        sumOfCaptainSalaries[i] = captainSalaries[i];
      else
        sumOfCaptainSalaries[i] = sumOfCaptainSalaries[i - 1] + captainSalaries[i];
    }
    System.out.println(solve(n, captainSalaries, assistantSalaries, sumOfCaptainSalaries);
    in.close();
  }

  private static int solve(int n, int[] captainSalaries, int[] assistantSalaries, int[] sumOfCaptainSalaries) {
    // return assistantSalaries[0] + charlieAndPilotsRecursive(n - 1, captainSalaries, assistantSalaries, 1, 1);
    return charlieAndPilotsIterative(n, captainSalaries, assistantSalaries, sumOfCaptainSalaries);
  }

  private static int charlieAndPilotsIterative(int n, int[] captainSalaries, int[] assistantSalaries, int[] sumOfCaptainSalaries) {
    int[][] dp = new int[2][n + 1];
    for(int i = 1; i <= n; i++) {
        dp[i & 1][i] = sumOfCaptainSalaries[n - 1] - sumOfCaptainSalaries[n - i - 1];
        dp[i & 1][0] = dp[!(i & 1)][1] + y[n-i];
    }
    return captainSalaries[n - 1] + dp[n - 1][n/2];
  }

  private static int charlieAndPilotsRecursive(int n, int[] captainSalaries, int[] assistantSalaries, int currentIndex,
      int diffOfAssistantsAndCaptains) {
    if (diffOfAssistantsAndCaptains < 0 || n <= 0 || diffOfAssistantsAndCaptains >= captainSalaries.length) {
      return Integer.MAX_VALUE;
    }

    if (currentIndex == captainSalaries.length - 1) {
      if (diffOfAssistantsAndCaptains == 1)
        return captainSalaries[captainSalaries.length - 1];
      else
        return Integer.MAX_VALUE;
    }
    if (diffOfAssistantsAndCaptains == 0)
      return assistantSalaries[currentIndex] + charlieAndPilotsRecursive(n - 1, captainSalaries, assistantSalaries,
          currentIndex + 1, diffOfAssistantsAndCaptains + 1);
    if (diffOfAssistantsAndCaptains == n)
      return captainSalaries[currentIndex] + charlieAndPilotsRecursive(n - 1, captainSalaries, assistantSalaries,
          currentIndex + 1, diffOfAssistantsAndCaptains - 1);

    int hiredAsAssistant = assistantSalaries[currentIndex] + charlieAndPilotsRecursive(n - 1, captainSalaries,
        assistantSalaries, currentIndex + 1, diffOfAssistantsAndCaptains + 1);
    int hiredAsCaptain = captainSalaries[currentIndex] + charlieAndPilotsRecursive(n - 1, captainSalaries,
        assistantSalaries, currentIndex + 1, diffOfAssistantsAndCaptains - 1);
    return Math.min(hiredAsAssistant, hiredAsCaptain);
  }
}
