package CodingNinjas.AdhocProblems;

import java.util.Scanner;

public class WinningStrategy {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n + 1];
    int count = 0;
    for (int i = 1; i <= n; i++)
      arr[i] = in.nextInt();

    for (int i = n; i >= 1; i--) {
      if (arr[i] == i)
        continue;
      else if (i - 1 > 0 && arr[i - 1] == i) {
        arr[i - 1] = arr[i];
        arr[i] = i;
        count++;
      } else if (i - 2 > 0 && arr[i - 2] == i) {
        arr[i - 2] = arr[i - 1];
        arr[i - 1] = arr[i];
        arr[i] = i;
        count += 2;
      } else {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
    System.out.println(count);
  }
}
