package CodingNinjas.SearchingAndSortingApplications;

import java.util.Scanner;

public class TajMahalEntry {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] windows = new int[n];
    for (int i = 0; i < n; i++) {
      windows[i] = in.nextInt() - i;
    }

    for (int i = 0; i < n; i++) {
      if (windows[i] <= 0) {
        System.out.println(i + 1);
        return;
      }
    }

    System.out.println(TajMahalEntry.solve(windows, n));
    in.close();
  }

  private static int solve(int[] windows, int n) {
    int currentLocation = 0;
    while (true) {
      windows[currentLocation] -= n;
      if (windows[currentLocation] <= 0) {
        return currentLocation + 1;
      }
      if (currentLocation == n - 1) {
        currentLocation = 0;
      } else {
        currentLocation++;
      }
    }
  }
}
