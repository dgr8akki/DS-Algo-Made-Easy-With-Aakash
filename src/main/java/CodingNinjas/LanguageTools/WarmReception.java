package CodingNinjas.LanguageTools;

import java.util.Scanner;
import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arrivals = new int[n], departures = new int[n];
    for (int i = 0; i < n; i++)
      arrivals[i] = in.nextInt();
    for (int i = 0; i < n; i++)
      departures[i] = in.nextInt();

    // Solution
    Arrays.sort(arrivals);
    Arrays.sort(departures);
    int arrivalRunner = 0, departureRunner = 0, mergedRunner = 0, maxGuest = -1, totalGuests = 0;
    while (arrivalRunner < n && departureRunner < n) {
      if (arrivals[arrivalRunner] <= departures[departureRunner]) {
        totalGuests++;
        maxGuest = Math.max(maxGuest, totalGuests);
        arrivalRunner++;
      } else {
        totalGuests--;
        departureRunner++;
      }
    }

    System.out.println(maxGuest);
  }
}
