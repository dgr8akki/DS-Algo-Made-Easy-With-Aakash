import java.util.Scanner;

/**
 * Party
 */
public class Party {

  private static void knapSackIterative(int[] weights, int[] values, int capacity) {
    int[][] solution = new int[weights.length + 1][capacity + 1];
    int totalItems = weights.length;
    for (int i = 1; i <= totalItems; i++)
      for (int w = 1; w <= capacity; w++) {

        int notTakingItem = solution[i - 1][w];
        int takingItem = 0;

        if (weights[i - 1] <= w)
          takingItem = values[i - 1] + solution[i - 1][w - weights[i - 1]];

        solution[i][w] = Math.max(takingItem, notTakingItem);
      }

    for (int k = 0; k <= capacity; k++) {
      if (solution[totalItems][k] == solution[totalItems][capacity]) {
        System.out.println(k + " " + solution[totalItems][capacity]);
        break;
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (true) {
      int budget = in.nextInt();
      int n = in.nextInt();
      if (budget == 0 && n == 0)
        break;
      int[] weight = new int[n];
      int[] value = new int[n];
      for (int i = 0; i < n; i++) {
        weight[i] = in.nextInt();
        value[i] = in.nextInt();
      }
      knapSackIterative(weight, value, budget);
    }
    in.close();
  }
}
