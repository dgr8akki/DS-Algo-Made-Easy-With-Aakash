import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  // Complete the solve function below.
  static int solve(int[][] shots, int[][] players) {

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("random.txt"));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] shots = new int[n][2];

    for (int shotsRowItr = 0; shotsRowItr < n; shotsRowItr++) {
      String[] shotsRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int shotsColumnItr = 0; shotsColumnItr < 2; shotsColumnItr++) {
        int shotsItem = Integer.parseInt(shotsRowItems[shotsColumnItr]);
        shots[shotsRowItr][shotsColumnItr] = shotsItem;
      }
    }

    int[][] players = new int[m][2];

    for (int playersRowItr = 0; playersRowItr < m; playersRowItr++) {
      String[] playersRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int playersColumnItr = 0; playersColumnItr < 2; playersColumnItr++) {
        int playersItem = Integer.parseInt(playersRowItems[playersColumnItr]);
        players[playersRowItr][playersColumnItr] = playersItem;
      }
    }

    int result = solve(shots, players);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
