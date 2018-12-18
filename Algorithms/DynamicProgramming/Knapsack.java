public class Knapsack {
  private int[] weights;
  private int[] values;
  private int capacity;
  private int[][] solution;
  private int totalItems;

  public Knapsack(int[] weights, int[] values, int capacity, int totalItems) {
    this.weights = weights;
    this.values = values;
    this.capacity = capacity;
    this.totalItems = totalItems;
    this.solution = new int[weights.length + 1][this.capacity + 1];
  }

  public void solve() {
    for (int i = 1; i < totalItems + 1; i++)
      for (int w = 1; w < capacity + 1; w++) {

        int notTakingItem = this.solution[i - 1][w];
        int takingItem = 0;

        if (weights[i] <= w)
          takingItem = values[i] + solution[i - 1][w - weights[i]];

        solution[i][w] = Math.max(takingItem, notTakingItem);
      }

    System.out.println("Total profit: " + this.solution[totalItems][capacity]);

    for (int n = totalItems, w = capacity; n > 0; n--)
      if (solution[n][w] != 0 && solution[n - 1][w] != solution[n][w]) {
        System.out.println("We will pick item# " + n);
        w -= weights[n];
      }
  }

  public static void main(String[] args) {
    int[] weights = { 0, 4, 2, 3 };
    int[] values = { 0, 10, 4, 7 };
    int capacity = 5;

    Knapsack knapsack = new Knapsack(weights, values, capacity, 3);
    knapsack.solve();
  }
}
