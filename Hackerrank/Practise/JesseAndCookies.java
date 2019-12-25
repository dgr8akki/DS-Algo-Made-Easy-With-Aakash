package Hackerrank.Practise;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class JesseAndCookies {
  static int cookies(int k, int[] A) {
    int temp[] = new int[A.length];
    int count = -1;
    for(int i = 0; i < A.length; i++)
      temp[i] = A[i];
    Arrays.sort(temp);
    while (temp[0] < k) {
      count++;
      int b = 1 * temp[0] + 2 * temp[1];
      temp[0] = b;
      temp[1] = Integer.MAX_VALUE;
      Arrays.sort(temp);
    }
    return count;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nk = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nk[0].trim());

    int k = Integer.parseInt(nk[1].trim());

    int[] A = new int[n];

    String[] AItems = scanner.nextLine().split(" ");

    for (int AItr = 0; AItr < n; AItr++) {
      int AItem = Integer.parseInt(AItems[AItr].trim());
      A[AItr] = AItem;
    }

    int result = cookies(k, A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
