package Hackerrank.Practise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MrXAndHisShots {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("random.txt"));

    String[] nm = MrXAndHisShots.scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] shots = new int[n][2];

    for (int shotsRowItr = 0; shotsRowItr < n; shotsRowItr++) {
      String[] shotsRowItems = MrXAndHisShots.scanner.nextLine().split(" ");
      MrXAndHisShots.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int shotsColumnItr = 0; shotsColumnItr < 2; shotsColumnItr++) {
        int shotsItem = Integer.parseInt(shotsRowItems[shotsColumnItr]);
        shots[shotsRowItr][shotsColumnItr] = shotsItem;
      }
    }

    int[][] players = new int[m][2];

    for (int playersRowItr = 0; playersRowItr < m; playersRowItr++) {
      String[] playersRowItems = MrXAndHisShots.scanner.nextLine().split(" ");
      MrXAndHisShots.scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int playersColumnItr = 0; playersColumnItr < 2; playersColumnItr++) {
        int playersItem = Integer.parseInt(playersRowItems[playersColumnItr]);
        players[playersRowItr][playersColumnItr] = playersItem;
      }
    }

    int result = 0;

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    MrXAndHisShots.scanner.close();
  }
}
