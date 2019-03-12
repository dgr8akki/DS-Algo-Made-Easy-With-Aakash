import java.io.*;
import java.util.*;

public class CountingValleys {

  // Complete the countingValleys function below.
  static int countingValleys(int n, String s) {
    boolean isGoesIntoValley = false;
    int count = 0;
    int level = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'D') {
        level--;
        if (level < 0)
          isGoesIntoValley = true;
      } else {
        level++;
      }
      if (level == 0 && isGoesIntoValley) {
        count++;
        isGoesIntoValley = false;
      }
    }
    return count;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();

    int result = countingValleys(n, s);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
