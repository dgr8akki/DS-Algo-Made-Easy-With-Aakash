package Hackerrank.InterviewPreparationKit.WarmUpChallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedStrings {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the repeatedString function below.
  private static long repeatedString(String s, long n) {
    long aIns = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        aIns++;
      }
    }

    long res = aIns * (n / s.length());
    for (int i = 0; i < (n % s.length()); i++) {
      if (s.charAt(i) == 'a') {
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = scanner.nextLine();

    long n = scanner.nextLong();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    long result = repeatedString(s, n);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
