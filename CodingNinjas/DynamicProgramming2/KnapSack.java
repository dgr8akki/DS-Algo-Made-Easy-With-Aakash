/**
 * KnapSack
 */
public class KnapSack {

  public static int knapsack(int[] weight,int value[],int maxWeight) {
    return knapsackRecursive(weight, value, maxWeight, 0);
	}

  private static int knapsackRecursive(int[] weight,int value[],int maxWeight, int currentItemIdx) {
    if(currentItemIdx >= value.length) return 0;
    int option1 = knapsackRecursive(weight, value, maxWeight, currentItemIdx + 1);
    int option2 = Integer.MIN_VALUE;
    if(maxWeight - weight[currentItemIdx] >= 0)
      option2 = value[currentItemIdx] + knapsackRecursive(weight, value, maxWeight - weight[currentItemIdx], currentItemIdx + 1);
    return Math.max(option1, option2);
	}
  public static void main(String[] args) {
    int[] w = {1, 2, 4, 5};
    int[] val = {5, 4, 8, 6};
    int cap = 5;
    System.out.println(knapsack(w, val, cap));
  }
}
