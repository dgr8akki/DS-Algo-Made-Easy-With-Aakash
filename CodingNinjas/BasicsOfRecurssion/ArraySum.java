package CodingNinjas.BasicsOfRecurssion;

class Solution {
  public static int sum(int input[]) {
    return sum(input, input.length - 1);
  }

  private static int sum(int input[], int index) {
    if (index < 0) return 0;
    return input[index] + sum(input, index - 1);
  }
}
