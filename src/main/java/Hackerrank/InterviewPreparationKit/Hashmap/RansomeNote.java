package Hackerrank.InterviewPreparationKit.Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomeNote {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the checkMagazine function below.
  private static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> dict = new HashMap<>();
    for (String word : magazine) {
      if (dict.containsKey(word)) {
        dict.put(word, dict.get(word) + 1);
      } else {
        dict.put(word, 1);
      }
    }

    for (String word : note) {
      if (!dict.containsKey(word) || dict.get(word) <= 0) {
        System.out.println("No");
        return;
      }
      dict.put(word, dict.get(word) - 1);
    }
    System.out.println("Yes");
  }

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
