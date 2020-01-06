package Leetcode;

class Solution_1176_DietPlanPerformance {
  public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
    int score = 0;
    for (int i = 0; i < calories.length - k + 1; i++) {
      int totalCalories = 0;
      for (int j = 0; j < k && i + j < calories.length; j++)
        totalCalories += calories[i + j];

      if (totalCalories < lower)
        score--;
      if (totalCalories > upper)
        score++;
    }
    return score;
  }
}
