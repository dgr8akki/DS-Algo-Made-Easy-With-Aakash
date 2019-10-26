package Hackerrank.InterviewPreparationKit.Hashmap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the twoStrings function below.
  private static String twoStrings(String s1, String s2) {
    int[] charSet = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      charSet[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s2.length(); i++) {
      if (charSet[s2.charAt(i) - 'a'] > 0) {
        return "YES";
      }
    }
    return "NO";
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      String s1 = scanner.nextLine();

      String s2 = scanner.nextLine();

      String result = twoStrings(s1, s2);

      bufferedWriter.write(result);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}
