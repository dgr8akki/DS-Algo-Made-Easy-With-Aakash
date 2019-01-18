class Solution {
  public static boolean checkNumber(int input[], int x) {
    if (input.length == 0)
      return false;
    if (input.length == 1)
      return input[0] == x;
    return checkNumber(input, 0, x);
  }

  private static boolean checkNumber(int[] input, int index, int x) {
    if (index == input.length)
      return false;
    if (x == input[index])
      return true;
    return checkNumber(input, index + 1, x);
  }
}