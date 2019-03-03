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
    for (int i = 0; i < n; i++) {
      captainSalaries[i] = in.nextInt();
      assistantSalaries[i] = in.nextInt();
    }
    System.out.println(solve(n, captainSalaries, assistantSalaries));
    in.close();
  }

  private static int solve(int n, int[] captainSalaries, int[] assistantSalaries) {
    return assistantSalaries[0] + charlieAndPilotsRecursive(n - 1, captainSalaries, assistantSalaries, 1, 1);
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
