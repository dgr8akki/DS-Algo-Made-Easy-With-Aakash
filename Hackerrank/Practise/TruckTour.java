package Hackerrank.Practise;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class TruckTour {

  private static class GasStation {
    int gas;
    int next;

    GasStation(int gas, int next) {
      this.gas = gas;
      this.next = next;
    }
  }

  static int truckTour(int[][] petrolpumps) {
    Queue<GasStation> queue = new LinkedList<GasStation>();
    for (int i = 0; i < petrolpumps.length; i++) {
      queue.add(new GasStation(petrolpumps[i][0], petrolpumps[i][1]));
    }

    int start = 0;
    int passed = 0;
    int gas = 0;

    while(passed < petrolpumps.length) {
      GasStation currentStation = queue.peek();
      gas += currentStation.gas;
      queue.poll();

      if(gas >= currentStation.next) {
        passed++;
        gas -= currentStation.next;
      } else {
        start += passed + 1;
        passed = 0;
        gas = 0;
      }
      queue.add(currentStation);
    }

    return start;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("random.txt"));

    int n = Integer.parseInt(scanner.nextLine().trim());

    int[][] petrolpumps = new int[n][2];

    for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
      String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

      for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
        int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
        petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
      }
    }

    int result = truckTour(petrolpumps);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}
